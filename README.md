# Anatomy Web Platform whole readme

https://github.com/hayridurmaz/anatomy-web-readme

# Anatomy-Web API Reference

## I. Topics

### 1. GetTopics

URL: `[url]/Topics`

URL example: `localhost:8080/Topics`

Request type: `Get`

Request Body example: `-`

Response example:

    [
        {
            "id": 9,
            "name": null
        },
        {
            "id": 12,
            "name": "topic example"
        }
    ]

### 2. GetTopicById

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/12`

Request type: `Get`

Request Body example:

    -

Response example:

    {
    "id": 12,
    "name": "topic example"
    }

### 3. AddTopic

URL: `[url]/Topics`

URL example: `localhost:8080/Topics`

Request type: `Post`

Request Body example:

    {"name": "topic example"}

Response example:

    {
    "id": 12,
    "name": "topic example"
    }

### 4. UpdateTopic

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/12`

Request type: `Put`

Request Body example:

    {"name": "topic example updated"}

Response example:

    {
    "id": 12,
    "name": "topic example updated"
    }

### 5. DeleteTopic

URL: `[url]/Topics/{topicId}`

URL example: `localhost:8080/Topics/9`

Request type: `Delete`

Request Body example:

    -

Response example:

    -

## II. Systems

### 1. GetSystems

URL: `[url]/Systems`

URL example: `localhost:8080/Systems`

Request type: `Get`

Request Body example: `-`

Response example:

    [
        {
            "id": 8,
            "name": null
        }
    ]

### 2. GetSystemById

URL: `[url]/Systems/{systemId}`

URL example: `localhost:8080/Systems/8`

Request type: `Get`

Request Body example:

    -

Response example:

    {
        "id": 8,
        "name": "system"
    }

### 3. AddSystem

URL: `[url]/System`

URL example: `localhost:8080/Systems`

Request type: `Post`

Request Body example:

    {
    "name": "system example"
    }

Response example:

    {
    "id": 14,
    "name": "system example"
    }

### 4. UpdateSystem

URL: `[url]/Systems/{systemId}`

URL example: `localhost:8080/Systems/8`

Request type: `Put`

Request Body example:

    {
    "name":"updated system"
    }

Response example:

    {
    "id": 8,
    "name": "updated system"
    }

### 5. DeleteSystem

URL: `[url]/Systems/{systemId}`

URL example: `localhost:8080/Systems/13`

Request type: `Delete`

Request Body example:

    -

Response example:

    -

## III. Images

### 1. GetImages

URL: `[url]/Images`

URL example: `localhost:8080/Images`

Request type: `Get`

Request Body example: `-`

Response example:

    [
        {
            "id": 16,
            "data_url": "Image1",
            "topic": {
                "id": 12,
                "name": "topic example updated"
            },
            "system": {
                "id": 14,
                "name": "system example"
            }
        },
        {
            "id": 17,
            "data_url": "Image2",
            "topic": {
                "id": 12,
                "name": "topic example updated"
            },
            "system": {
                "id": 14,
                "name": "system example"
            }
        }
    ]

### 2. GetImageById

URL: `[url]/Images/{ImageId}`

URL example: `localhost:8080/Images/16`

Request type: `Get`

Request Body example:

    -

Response example:

    {
        "id": 16,
        "data_url": "Image1",
        "topic": {
            "id": 12,
            "name": "topic example updated"
        },
        "system": {
            "id": 14,
            "name": "system example"
        }
    }

### 3. AddImage

URL: `[url]/Images`

URL example: `localhost:8080/Images`

Request type: `Post`

Request Body example:

    {
        "data_url": "Image1",
        "topic_id": 12,
        "system_id": 14
    }

Response example:

    {
        "id": 16,
        "data_url": "Image1",
        "topic": {
            "id": 12,
            "name": "topic example updated"
        },
        "system": {
            "id": 14,
            "name": "system example"
        }
    }

### 4. UpdateImage

URL: `[url]/Images/{imageId}`

URL example: `localhost:8080/Images/16`

Request type: `Put`

Request Body Interface:

    {
    "data_url"?: string,
    "topic_id"?: number
    "system_id"?: number
    }

Request Body example:

    {
            "data_url": "data url updated"
    }

or

    {
            "system_id": "8"
    }

or

    {
            "system_id": "8",
            "data_url": "data url updated"
    }

Response example:

    {
        "id": 16,
        "data_url": "data url updated",
        "topic": {
            "id": 12,
            "name": "topic example updated"
        },
        "system": {
            "id": 8,
            "name": "updated system"
        }
    }

### 5. DeleteImage

URL: `[url]/Images/{imageId}`

URL example: `http://localhost:8080/Images/17`

Request type: `Delete`

Request Body example:

    -

Response example:

    -

## IV. Quiztype

### 1. Get Quiztypes

URL: `[url]/Quiztypes`

URL example: `localhost:8080/Quiztypes`

Request type: `Get`

Request Body example: `-`

Response example:
`[ { "id": 7, "name": "SINGLE SELECTION" }, { "id": 8, "name": "MULTIPLE SELECTION" } ]`

### 2. Get Quiztype By Id

URL: `[url]/Quiztypes/{QuiztypeId}`

URL example: `localhost:8080/Quiztypes/7`

Request type: `Get`

Request Body example: `-`

Response example:
`{ "id": 7, "name": "SINGLE SELECTION" }`

### 3. Add Quiztype

URL: `[url]/Quiztypes`

URL example: `localhost:8080/Quiztypes`

Request type: `Post`

Request Body example:
`{ "name": "NEW QUIZ TYPE" }`

Response example:
`{ "id": 9, "name": "NEW QUIZ TYPE" }`

### 4. Update Quiztype

URL: `[url]/Quiztypes/{QuiztypeId}`

URL example: `localhost:8080/Quiztypes/28`

Request type: `Put`

Request Body example:
`{ "name": "UPDATED QUIZ TYPE" }`

Response example:

`{ "id": 28, "name": "UPDATED QUIZ TYPE" }`

### 5.Delete Quiztype

URL: `[url]/Quiztypes/{QuiztypeId}`

URL example: `localhost:8080/Quiztypes/28`

Request type: `Delete`

Request Body example:
`-`

Response example:
`-`

## IV. Quiz

### 1. Get Quizzes

URL: `[url]/Quizzes`

URL example: `localhost:8080/Quizzes`

Request type: `Get`

Request Body example:
`-`

Response example:
`[ { "quiztype": { "id": 7, "name": "SINGLEE SELECTION" }, "system": { "id": 3, "name": "system1" }, "questions": [], "id": 9 } ]`

### 2. Get Quiz By Id

URL: `[url]/Quizzes/{QuizId}`

URL example: `localhost:8080/Quizzes/9`

Request type: `Get`

Request Body example:
"quiztype": {
"id": 7,
"name": "SINGLEE SELECTION"
},
"system": {
"id": 3,
"name": "system1"
},
"questions": [],
"id": 9
}`

Response example:
`-`

### 3. Add Quiz

URL: `[url]/Quizzes`

URL example: `localhost:8080/Quizzes`

Request type: `Post`

Request Body example:
` {

    {
            "quiz_type_id": 7,
            "system_id": 3
    }

Response example:
`{ "quiztype": { "id": 7, "name": "SINGLEE SELECTION" }, "system": { "id": 3, "name": "system1" }, "questions": null, "id": 9 }`

### 4. Update Quiz

URL: `[url]/Quizzes/{QuizId}`

URL example: `localhost:8080/Quizzes/9`

Request type: `Put`

Request Body Interface:

    {
            "quiz_type_id"?: 28,
            "system_id"?: 23
    }

Request Body example:

    {
            "quiz_type_id": 8,
    }

or

    {
            "system_id"?: 4
    }

or

    {
            "quiz_type_id": 8,
            "system_id"?: 4
    }

Response example:

    {
    "quiztype": {
        "id": 8,
        "name": "MULTIPLE SELECTION"
    },
    "system": {
        "id": 4,
        "name": "system2"
    },
    "questions": [],
    "id": 9
    }

### 5. Delete Quiz

URL: `[url]/Quizzes/{QuizId}`

URL example: `localhost:8080/Quizzes/9`

Request type: `Delete`

Request Body example:
`-`

Response example:
`-`

## V. Question

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTg2MTU1MTA4MCwtNTg4NDgxNzMyLDEwMj
U5ODk3MzAsMjcyMTAwMTMyLC0zNTkyMTAyNTAsLTk2Mjc5NjIy
MiwxMzI0ODc0NTkxLDEzMzUwOTc5ODMsODEzMjI3MTI2XX0=
-->
