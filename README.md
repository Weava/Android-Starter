# Android-Starter
A simple starter project for Android that should clear up all the annoying boiler plate necessary for starting a new Android project.
Inspired heavily by [Fernando Cejas's Clean Architecture](https://github.com/android10/Android-CleanArchitecture).


### Libraries Included

This starter project includes the following libraries:
 * RxJava
 * Dagger 2
 * Butterknife
 * OkHttp
 * Gson
 * Retrofit
 * Many other common libraries
 
### What do I do after cloning?

Before you get started on creating your own application from this starter project, make sure you do the following:
 * Modify the package name in both the project level build.gradle file and AndroidManifest.xml files in the data and app modules.
 You should also re-name the source set packages to match.
 * Change the applicationId and update all build tool and dependency versions to latest. 
 * Do a find and replace for the following tag `<a href="mailto:aaron@appweava.com">Aaron Weaver</a>` with 
 `<a href="mailto:<your-email>"><your-name></a>` unless you want people to e-mail me about bugs in your app.
 (You'll also want to do a find and replace for the date)
 * Remove any files you deem unnecessary (Don't need a drawer? Delete drawer related files)
 * Modify the Git remote to point to your repository:
 
    ```
    git remote remove origin
    git remote add origin '<your-url-here>'
    ```
 * Remove Git history with the following commands:
 
     ```
     git rebase --root -i
     git commit --amend -m "<first-commit-message>"
     git push --force
     git fetch --prune
     ```
     
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
* Alongside the `feature` package, I would like to implement an example of user account log-in/sign-up, as these operations are common. This would appear in a `user` package.
* Testing examples would be setup for each unit within the `feature` and `user` packages. This would establish a small
  guide on how to write unit tests throughout your own application.
* Create a more descriptive readme that would have a more in-depth discussion on how this app is structured.
* Comments. Comments. Comments.

### Special thanks

* [Fernando Cejas](https://github.com/android10)
* [Square](https://github.com/square)
* [Jake Wharton](https://github.com/JakeWharton)
* [Marcus Gabilheri](https://github.com/fnk0)
* [Kyle Riedemann](https://github.com/kylealanr)
