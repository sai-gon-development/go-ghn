package routes

import (
	"github.com/gin-gonic/gin"
	"github.com/sai-gon-development/go-ghn/go-ghn-service/apis/controllers"
)

func UserRoute(router *gin.Engine) {
	router.POST("/user", controllers.CreateUser())
	router.GET("/user/:userId", controllers.GetAUser())
	router.PUT("/user/:userId", controllers.EditAUser())
	router.DELETE("/user/:userId", controllers.DeleteAUser())
	router.GET("/users", controllers.GetAllUsers())
}