# Compose-Loading-Dots
simple Library to have Progresses dots loading by compose, this is compose version [Android-Loading-Dots](https://github.com/razaghimahdi/Android-Loading-Dots)
## Developed by Mahdi Razzaghi Ghaleh

[![](https://jitpack.io/v/razaghimahdi/Compose-Loading-Dots.svg)](https://jitpack.io/#razaghimahdi/Compose-Loading-Dots)

# Step1. Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

# Step 2. Add the dependency
	dependencies {
	        implementation 'com.github.razaghimahdi:Compose-Loading-Dots:Tag'
	}
	Current Ver:"1.0"

# Step 3. How to use
```kotlin

        LoadingWavy(modifier = Modifier.padding(vertical = 8.dp))

        LoadingFady(modifier = Modifier.padding(vertical = 8.dp))

        LoadingBiggy(modifier = Modifier.padding(vertical = 8.dp))

```

Done !!!


https://user-images.githubusercontent.com/61207818/213859573-a715bd39-1167-49ea-9a9d-a6e5f5b815dd.mp4

