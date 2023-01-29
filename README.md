# Compose Loading Dots

A library which allows you to have some beautiful loading with dots by **Jetpack Compose**.

> If you need this in XML then try [Android-Loading-Dots](https://github.com/razaghimahdi/Android-Loading-Dots).


[![Compose Loading Dots](https://jitpack.io/v/razaghimahdi/Compose-Loading-Dots.svg)](https://jitpack.io/#razaghimahdi/Compose-Loading-Dots)

## Step1. Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

## Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.razaghimahdi:Compose-Loading-Dots:1.2.3'
	} 

## Step 3. How to use

```kotlin
val rememberDotsLoadingWavyController = rememberDotsLoadingController()
val rememberDotsLoadingFadyController = rememberDotsLoadingController()
val rememberDotsLoadingBiggyController = rememberDotsLoadingController()
val rememberLoadingScalyController = rememberDotsLoadingController()
val rememberLoadingDancingController = rememberDotsLoadingController()
val rememberLoadingCircleFadyController = rememberDotsLoadingController()


LoadingWavy(controller = rememberDotsLoadingWavyController)

LoadingFady(controller = rememberDotsLoadingFadyController)

LoadingBiggy(controller = rememberDotsLoadingBiggyController)

LoadingScaly(controller = rememberLoadingScalyController)

LoadingDancing(controller = rememberLoadingDancingController)

LoadingCircleFady(controller = rememberLoadingCircleFadyController)
```

## Step 4. How to initial

```kotlin
val rememberDotsLoadingWavyController = rememberDotsLoadingController()
LoadingWavy(
    controller = rememberDotsLoadingWavyController,
    modifier = Modifier.padding(vertical = 8.dp),
    dotsCount = 3,
    dotsColor = Color.Red,
    dotsSize = 25.dp,
    duration = 300,
    easing = LinearEasing
)
```

OR

```Kotlin
val rememberDotsLoadingWavyController = rememberDotsLoadingController()
rememberDotsLoadingWavyController.updateSelectedDotsCount(3)
rememberDotsLoadingWavyController.updateSelectedDotsDuration(300)
rememberDotsLoadingWavyController.updateSelectedEasing(LinearEasing)
rememberDotsLoadingWavyController.updateSelectedDotsColor(Color.Red)
rememberDotsLoadingWavyController.updateSelectedDotsSize(25.dp)

LoadingWavy(
    controller = rememberDotsLoadingWavyController,
    modifier = Modifier.padding(vertical = 8.dp)
)
```

https://user-images.githubusercontent.com/61207818/215316569-fdb16d2f-1f49-4c37-a3af-d940cdf2cd1b.mp4

Developed by Mahdi Razzaghi Ghaleh
