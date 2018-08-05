package main

import (
	"github.com/gorilla/mux"
	"encoding/json"
    "log"
	"net/http"
	"strconv"
	"time"
)

func main() {
    r := mux.NewRouter()
	r.HandleFunc("/{value}", ValueHandler).Methods("GET")
	log.Println("Example app listening at http://localhost:8081")
	log.Fatal(http.ListenAndServe(":8081", r))
}


func ValueHandler(writer http.ResponseWriter, request *http.Request) {
	log.Println(">>> Request received")
	writer.Header().Set("Content-Type", "text/plain")
	//Converts the id parameter from a string to an int
    id, err := strconv.Atoi(mux.Vars(request)["value"])
    if err == nil {
		time.Sleep(time.Duration(3)*time.Second)
        json.NewEncoder(writer).Encode(id)
		log.Println("<<< Response sent")
    } else {
        log.Fatal(err.Error())
    }
}