# Weather Report Android App

## Getting started

### Step 1: Download the project
1. `git clone git@github.com:GoodRx/mobile-apps-shared.git`
2. `git clone git@github.com:GoodRx/android-consumer.git`
3. `cd weatherreport`

### Step 2: Setup Android Studio
1. Download Android Studio [here](https://developer.android.com/studio)
2. Start Android Studio and set latest compile SDK


### Step 2: Create your Design
1. Create your Weather design
2. Use "WeatherRepository" to get the Weather report

### Step 3: For DI(dependency Injection)
1. Integrate Koin for DI [here](https://insert-koin.io/docs/quickstart/android-viewmodel)
1. Use Koin to Inject WeatherRepository (it will be easy to  use it because library used Koin DI for implementation)
2. Add `libarymodule` in your Project module

Ex :` val appModule = module {
   viewModel { WeatherDetailViewModel(get()) }
   viewModel { WelcomeScreenViewModel() }
   }.plus(libraryModule)`

### Step 4: For API calling
1. Use coroutine [here](https://developer.android.com/kotlin/coroutines) to use the weather API 
2. call `getWeatherInformation` by `weatherRepository`

Ex :   `fun getWeatherInfo(latitude : String , longitude : String
   ) = viewModelScope.launch {
   _weatherResponse.value = weatherRepository.getWeatherInformation(latitude,longitude,"hourly,minutely","ae1c4977a943a50eaa7da25e6258d8b2","Metric","4")
   }`

### Step 4: Happy Coding!


#### Unit testing of logics and functionality
All functions has been tested by JUnit in library 

