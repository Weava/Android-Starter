# This is quite outdated at this point, Keeping for legacy / historical purposes

# Android-Starter
A simple starter project for Android that should clear up all the annoying boiler plate necessary for starting a new Android project.
Inspired heavily by [Fernando Cejas's Clean Architecture](https://github.com/android10/Android-CleanArchitecture).


### Libraries Included

This starter project includes the following libraries:
##### For Production:
 * [Android Support Library](https://github.com/android/platform_frameworks_support)
 * [Dagger 2](https://github.com/google/dagger)
    * A light dependency injection framework built in Java
 * [Butterknife](https://github.com/JakeWharton/butterknife)
    * View binding framework that allows you to skip all those `findViewById()` calls
 * [RxJava](https://github.com/ReactiveX/RxJava)
    * Library that handles multi-threading, single way data-flow, and in-flight data manipulation
 * [Picasso](https://github.com/square/picasso)
    * Simple image loading and cacheing library
 * [Gson](https://github.com/google/gson)
    * JSON serialization/deserialization library
 * [OkHttp](https://github.com/square/okhttp)
    * Library that handles networking and caching of network requests
 * [Retrofit](https://github.com/square/retrofit)
    * Network layer abstraction library that turns your REST client into an interface
 * [Auto Value](https://github.com/google/auto/tree/master/value)
    * Simple POJO generating library
 * [Adapter Delegates](https://github.com/sockeqwe/AdapterDelegates)
    * Allows recycler adapters to delegate functionality to adapter delegates, making multi-layout recycler views easier to work with
 * [Store](https://github.com/NYTimes/Store)
    * Data store abstraction library that makes retrieving and persisting data from and to external sources very easy.

##### For Testing:
 * [JUnit](https://github.com/junit-team/junit4)
 * [AssertJ](https://github.com/square/assertj-android)
 * [Mockito](https://github.com/mockito/mockito)
 * [Dexmaker](https://github.com/linkedin/dexmaker)
 * [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/)
 * [Testing Support Library](https://google.github.io/android-testing-support-library/)

##### Development Tools:
 * [Leak Canary](https://github.com/square/leakcanary)
    * Library that detects memory leaks in your app
 * [Timber](https://github.com/JakeWharton/timber)
    * Simple custom logging library for Android
 * [Stetho](http://facebook.github.io/stetho/)
    * Stetho allows you to debug network calls, view your sqlite database on-device, and has many other neat features
 * [Crashlytics](http://try.crashlytics.com/)
    * Crashlytics provides post-release error and crash reporting from consumer devices

### What do I do after cloning?

Before you get started on creating your own application from this starter project, make sure you do the following:
 * Modify the package name in both the project level build.gradle file and AndroidManifest.xml files in the data and app modules.
 You should also re-name the source set packages to match.
 * Change the applicationId and update all build tool and dependency versions to latest.
 * Remove any files you deem unnecessary (Don't need a drawer? Delete drawer related files)
 * If you wish to remove git history, simply delete the .git folder and create a new one with `git init`
 * Customize the `AppTheme` to whatever you desire, or modify the `colors.xml` file to get a new palette going.
 * Setup the `nav_header.xml` and `drawer_menu.xml` layouts to your own specs.
 * Either delete the `feature` package in each module, or use it as a guideline for your application flow.
 * Code away!

### What can I do with this repo?

Fork it, modify it in any way you want, I don't care what you do.
You don't even have to give me credit (It would be appreciated though :) )

If you have any issues with this starter project, or would like to make suggestions, start a discussion in the
issues.

### Future plans

* ~~The `feature` package should have a good example of how to design your application flow within each module.~~
* ~~Testing examples would be setup for each unit within the `feature` and `user` packages. This would establish a small
  guide on how to write unit tests throughout your own application.~~
* Add an actual example app for the feature packages
* Create a more descriptive readme that would have a more in-depth discussion on how this app is structured.
* Comments. Comments. Comments.

### Special thanks

* [Fernando Cejas](https://github.com/android10)
* [Square](https://github.com/square)
* [Jake Wharton](https://github.com/JakeWharton)
* [Marcus Gabilheri](https://github.com/fnk0)
* [Kyle Riedemann](https://github.com/kylealanr)
