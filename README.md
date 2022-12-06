### Create User : POST http://localhost:8080/user

- Body :

```json
{
  "username": "Jean",
  "birthDate": "2000-12-02T12:25:28.318Z",
  "country": "France",
  "phone": "xxx-xxx-xxx",
  "gender": "MALE"
}
```

#### Constraints :

- Username :
    - Not null
    - Not empty
    - Unique
- birthDate :
    - Must be at least 18years from now
    - Not null
- Country :
    - Not null
    - Not empty
    - Must be equals to "France"
- Phone :
    - Nullable
    - Size must be between 4 and 12 (french standard)
- Gender :
    - Nullable
    - Value must be MALE | FEMALE | OTHER

#### Result : The created user with the id attribute

```json
{
  "id": 1,
  "username": "Jean",
  "birthDate": "2000-12-02T12:25:28.318Z",
  "country": "France",
  "phone": "xxx-xxx-xxx",
  "gender": "FEMALE"
}
```

### Fetch User : GET http://localhost:8080/user/{userId}

#### Result : The created user with the id attribute

```json
{
  "id": 1,
  "username": "Jean",
  "birthDate": "2000-12-02T12:25:28.318Z",
  "country": "France",
  "phone": "xxx-xxx-xxx",
  "gender": "FEMALE"
}
```
