package main

import (
	"github.com/gin-gonic/gin"
	"github.com/sai-gon-development/go-ghn/go-ghn-service/apis/routes"
	"github.com/sai-gon-development/go-ghn/go-ghn-service/configs"
	swaggerfiles "github.com/swaggo/files"
	ginSwagger "github.com/swaggo/gin-swagger"
)

func main() {
	router := gin.Default()
	router.SetTrustedProxies([]string{"127.0.0.1"})

	//run database
	configs.ConnectDB()

	//routes
	routes.UserRoute(router)
	router.GET("/swagger/*any", ginSwagger.WrapHandler(swaggerfiles.Handler))
	router.Run("localhost:6000")
}
