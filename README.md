# AutoMapper

Allows you to map two classes for you. It uses the Gson library in doing this. Contains functions created using Gson.

## Installation

Add it in your root build.gradle at the end of repositories:

```bash
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```bash
implementation 'com.github.ResulSilay:AutoMapper:1.0.0'
```

## Usage

```kotlin
data class UserModel(
    val id: Int,
    val name: String,
    val password: String,
    val address: String,
    val phone: String
)

data class UserRequest(
    val id: Int,
    val name: String,
    val address: String
)
```


```kotlin
val userModel = UserModel(
    id = 1,
    name = "Yunus Emre",
    password = "123",
    address = "Turkey",
    phone = "05350000000"
)

val userDTO = AutoMapper.map<UserRequest>(userModel)
```

```kotlin
val userDTO = AutoMapper.map<List<UserRequest>>(userModelList)
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
