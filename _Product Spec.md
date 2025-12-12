---
title: ' Product Spec'

---

# **Prep Proper**

## Table of Contents

1. App Overview
1. Product Spec
1. Wireframes
1. Build Notes

## App Overview

### Description 

**Prep proper is an app designed to help you with your diet and fitness goals. Curate your own workout split and checklist whether you completed the workout for the day. Meal prep for your week by selecting your preferred food items, displayign their nutritional value and granting you a list of recipes.**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

- **Category: Health and Fitness**
- **Mobile: The fitness and dietary goals of the app are personal, meaning that you can create a schedule that is your own in any manner you please.**
- **Story: To create an app where yout standards are your own. Fitness is essential to life, and unfortunately, due to the sedentary conditions of our surroundings, we tend to forget that. This app seeks to create a healthier, more active society.**
- **Market: For anyone who seeks to get into fitness or is already in fitness who may need to adjust or create new goals.**
- **Habit: The habit is dependant on the user. Whether they wish to split a routine into 3 days or 6 is up to them.**
- **Scope:There are a wide set of features from this app that are generally broken down into two categories: exercise and diet. They can be used either separately or have their features meshed together.**

## Product Spec

### 1. User Features (Required and Optional)

Required Features:

*  Create a workout split
*  Log daily workouts (check off completed days)
*  Add meals and select food items
*  Auto-calculate calories and macros
*  Weekly meal plan view
- 

Stretch Features:

* Recipe suggestions pulled from a recipe API
* Progress tracker showing estimated time to reach weight goal
* Barcode scanner for food items
* Notifications for meals/workouts

### 2. Chosen API(s)

- API 1= Nutrition API
    - (Provides calories, protein, fat, carbs for each food)
(Used for meal logging + macro tracking)
    - https://fdc.nal.usda.gov/api-guide
- API 2: Recipe API
    - (Provides recipes based on ingredients)
    - (Used for meal prep ideas + linking to macro goals)
    - https://www.themealdb.com/api.php

### 3. User Interaction

Required Feature


- Meal Logging

    - User selects food item → App shows macros + adds it to daily total

- Workout Split

    - User creates weekly split → App saves routine + lets them check off days

 - Weight Goal

    - User enters current + goal weight → App shows estimated time based on calories

## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://imgur.com/oYb6gLG.png" width=200>
<img src="https://i.imgur.com/gLjRvSm.png" width=200>
<img src="https://i.imgur.com/VXlVZ9j.png" width=200>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ Videos/GIFs** of the build process here!
![api](https://github.com/user-attachments/assets/b428782e-7713-4145-87bf-35684d12536f)

![search](https://github.com/user-attachments/assets/43a3b9b1-4a5b-4a2d-83e8-46e27e183c1b)



## License

Copyright **yyyy** **your name**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
