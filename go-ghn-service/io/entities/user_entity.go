package models

import (
	"time"

	"go.mongodb.org/mongo-driver/bson/primitive"
)

type User struct {
	Id       primitive.ObjectID
	Name     string
	Location string
	Title    string
	Time     time.Time
}
