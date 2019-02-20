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
`[
    {
        "id": 7,
        "name": "SINGLE SELECTION"
    },
    {
        "id": 8,
        "name": "MULTIPLE SELECTION"
    }
]`

### 2. Get Quiztype By Id

URL: `[url]/Quiztypes/{QuiztypeId}`

URL example: `localhost:8080/Quiztypes/7`

Request type: `Get`

Request Body example: `-`

Response example:
`{
    "id": 7,
    "name": "SINGLE SELECTION"
}`

### 3. Add Quiztype

URL: `[url]/Quiztypes`

URL example: `localhost:8080/Quiztypes`

Request type: `Post`

Request Body example: 
`{
        "name": "NEW QUIZ TYPE"
    }`

Response example:
`{
    "id": 9,
    "name": "NEW QUIZ TYPE"
}`

### 4. Update Quiztype

URL: `[url]/Quiztypes/{QuiztypeId}`

URL example: `localhost:8080/Quiztypes/28`

Request type: `Put`

Request Body example: 
`{
        "name": "UPDATED QUIZ TYPE"
    }`

Response example:

`{
    "id": 28,
    "name": "UPDATED QUIZ TYPE"
}`

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

Request type: `Delete`

Request Body example: 
`-`

Response example:
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE4MTQ4MzExNTIsODEzMjI3MTI2XX0=
-->