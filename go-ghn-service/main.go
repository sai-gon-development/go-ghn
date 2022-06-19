package main

import (
	"github.com/gin-gonic/gin"
	"github.com/sai-gon-development/go-ghn/apis/routes"
	"github.com/sai-gon-development/go-ghn/configs"
	swaggerfiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
	eureka "github.com/xuanbo/eureka-client"
)

func main() {
	// create eureka client
	client := eureka.NewClient(&eureka.Config{
		DefaultZone:           "http://richard:richard@127.0.0.1:1001/eureka/",
		App:                   "go-ghn",
		Port:                  10000,
		RenewalIntervalInSecs: 10,
		DurationInSecs:        30,
		Metadata: map[string]interface{}{
			"VERSION":              "0.1.0",
			"NODE_GROUP_ID":        0,
			"PRODUCT_CODE":         "DEFAULT",
			"PRODUCT_VERSION_CODE": "DEFAULT",
			"PRODUCT_ENV_CODE":     "DEFAULT",
			"SERVICE_VERSION_CODE": "DEFAULT",
		},
	})
	// start client, register、heartbeat、refresh
	client.Start()

	router := gin.Default()
	router.SetTrustedProxies([]string{"127.0.0.1"})

	//run database
	configs.ConnectDB()

	//routes
	routes.UserRoute(router)
	router.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerfiles.Handler))
	router.Run("localhost:6000")
}
