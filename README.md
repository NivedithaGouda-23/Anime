# Anime App

A simple anime discovery app that fetches top anime and anime details using the Jikan API.

## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Architecture](#architecture)
6. [Dependencies](#dependencies)
7. [Contributing](#contributing)
8. [License](#license)

## Project Overview
This project is an Android application built with **Jetpack Compose**, **Dagger Hilt** for dependency injection, and **Kotlin**. The app allows users to explore the top anime and view detailed information about individual anime using the Jikan API.

## Features
- **Home Screen**: Displays a list of top anime.
- **Details Screen**: Shows detailed information about each anime.
- **State Management**: Uses **StateFlow** and **ViewModel** for efficient state handling.
- **Network Requests**: Fetches anime data from the Jikan API.
- **Dependency Injection**: Managed using **Dagger Hilt**.
- **Error Handling**: Displays error messages if fetching data fails.

## Installation
To get started with the Anime App:

1. **Clone the repository**:
    ```bash
    git clone[https://github.com/yourusername/anime-app.git](https://github.com/NivedithaGouda-23/Anime.git)
    cd anime-app
    ```

2. **Open the project in Android Studio**:
    - Make sure your SDK and JDK are set up correctly.

3. **Build the project**:
    - Click on **Build > Make Project** in Android Studio.

4. **Run the App**:
    - If you're running the app on an emulator or device, make sure you have **internet access** to fetch the anime data.
    - Click on the **Run** button in Android Studio to start the app on your emulator or device.

## Usage
1. **Navigating the App**:
    - **Home Screen**: Displays a list of top anime. Click on any anime to navigate to the detail screen.
    - **Details Screen**: Displays detailed information about the selected anime.

## Architecture
The app follows modern Android architecture practices:

- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **StateFlow**: Used to manage the UI state reactively.
- **Repository Pattern**: Handles data logic and provides data to the ViewModel.
- **Dagger Hilt**: Dependency injection to ensure a modular and testable architecture.
- **Retrofit**: Makes network requests to the Jikan API.

### Data Flow:
1. The **ViewModel** makes network requests via the **Repository**.
2. The **Repository** calls the **ApiService** to fetch data from the Jikan API.
3. The **StateFlow** is used to update the UI based on the data response.
4. The UI reacts to state changes by observing the **StateFlow** from the **ViewModel**.

## Dependencies
This project uses the following libraries:

- **Jetpack Compose**: UI toolkit for building native Android apps.
- **Dagger Hilt**: Dependency Injection library for Android.
- **Retrofit**: Type-safe HTTP client for Android to interact with APIs.
- **OkHttp**: Networking library for handling HTTP requests.
- **Gson**: Library for converting Java objects into JSON and vice versa.
- **Chucker**: HTTP inspector for debugging requests and responses.
