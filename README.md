Android Kotlin Clean Architecture App
=======================================

A Clean Architecture App that uses feature Modularization Architecture (app, presentation, domain, data, buildSrc) modules
to hit TMDB API using MVVM Architecture, Coroutines, Retrofit2, Live Data, Data Binding, Koin, SOLID Principles,
Unit Testing using MockK/Mockito and UI Testing using Espresso.

![app_screenshot](https://user-images.githubusercontent.com/39988066/147698906-c202b1bd-7530-4b6d-86e2-c3a8f3739325.jpeg)
![app_screen](https://user-images.githubusercontent.com/39988066/147701540-f739a86c-f797-4431-b1c1-e84b788d0b24.jpg)
![app_screenshot](https://user-images.githubusercontent.com/39988066/147701592-7afad608-35b5-4a89-a9d7-25ba529de4d3.jpg)

Introduction
-------------

### Layers
![3layer-1](https://user-images.githubusercontent.com/39988066/147699856-bc10356a-4772-439d-a2c1-b6020843f936.png)

#### UI or Presentation Layer
- This layer has all the Android UI components like Activities, Fragments, ViewModels, etc.

#### Domain Layer
- Contains all the business logic of the app. This layer has no Android components in it.

#### Data Layer
- All components related to data such as database, networking, api, shared preferences. It is an Android specific layer.

### Modules
![depends](https://user-images.githubusercontent.com/39988066/147700089-345e1a60-1651-4121-8616-f9273f8e0412.png)

#### App Module
- Considered as entery point for the app
- Contains (Activity) that hosts presentation view
- Contatins BaseApplication and all needed app info

#### Domain Module
- Contains business model 
- Contains business USECASES
- Repository interface

#### Data Module
- Repository Implementation
- Executor API data
- Mapper data model to domain model
- Contains data service, third party data service  

#### Presentation Module
- View (Fragment/Layout) Adapt data to view 
- Follows MVVM Architecture
- Mapper domain model to presentation model
- Handle data input from view via UseCase

#### BuildSrc Module
- Allows organizing gradle dependencies between all modules by using KTS

### Unit Test
You can easily write Unit Test up to 70% code coverage lines of code (LOC), if you write focus on 
- Data: RepositoryImpl, Model Mapper 
- Domain: UseCases
- Presentation: ViewModel, Model Mapper

License
--------

 Copyright (C) 2021 Shehab Alaa

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
