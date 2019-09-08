<snippet>
  <content><![CDATA[
# ${1:Weather Forecast}
This project is sample application which shows weather forecast information for any requested city, here it's integrated with APIXU api
for more information on api details please visit APIXU[https://www.apixu.com]

## Installation
To install this application please follow below steps:
1. Unzip folder
2. minSdkVersion=16 
3. Install the apk

## Code
Architecture Used: MVP (Added base classes for complete architecture)
Project Structure: Modular
Folder Structure:
1. base: Includes all the base classes of architecture
2. domain: Includes Presenter and Interactor classes
3. model: Includes all response model
4. network: Includes api constants and call
5. view: Includes UI such as activity and adapter classes

Main Entry Class: WeatherForecastActivity
Model Main Classes: CurrentWeatherResponse, WeatherForecastResponse
View Main Classes: WeatherForecastActivity, WeatherForecastAdapter
Presenter Main Classes: WeatherPresenter



##Libraries Used:
Libraries used from development point of view
1.Recycler View: Optimise the view scrolling in UI point of view
2.RX Java: For making async api call
3.RetroFit: For network layer point of view it's provide good abstraction over network layer.

Libraries used from Testing point of view
Mockito: It's help in mocking dependencies and help in writing unit test cases independently.


## Credits
This project is solely developed and maintained by Diptika Shukla.
]]></content>
  <tabTrigger>readme</tabTrigger>
</snippet>