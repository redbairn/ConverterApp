# ConverterApp
## Creating Web Services, Part I - Roman Numeral Converter (45%)


*Overview*

For this part you must create a Java program to convert a roman numeral to a decimal and vice-versa.

Example:

**Input** 1079
**Output** MLXXIX

### Conversion Example

To convert 2012 into a roman numeral.

**Step 1** Identify the highest number which fits into 2012, R is the remainder after subtracting the value
from 2012 i.e. R = 2012 - 1000

**Step 2** You then repeat the procedure with R. Keeping track of the numeral corresponding to the biggest
number that fits.

Repeat until the number R is Zero.

*Table 1: Roman Numeral Values*

Numeral  | Roman Numeral Values
-------- | -------------
4 		 |   IV
5 		 |	 V
9 		 |	 IX
10 		 |   X
40 		 |	 XL
50 		 |   L
90 		 |	 XC
100 	 |	 C
400 	 |   CD
500 	 |   D
1000	 |   M

## Create a Web Service, Part II - API Proxy (45%)

Now you must take the functionality completed in Part I and create a web service which provides this
functionality. In the case of the Roman numeral converter no UI is required. You can use the
Celsius-Fahrenheit converter project covered on previous class as blueprint. In these cases you don’t
need to develop a client as the browser acts as one by providing the GET method to act on the resource
defined. Final 20% reserved for bi-directional transformation (from decimal to roman numeral supported by the API).

*Overview*

Develop an API proxy for acquiring weather data, you will be acting as a proxy server as defined to be "a
server that acts as an intermediary for requests from clients seeking resources from other servers".

**Step 1** The user will make a request to your application specifying a city (a GET). Your appointed method
on the server will make a client connection to http://openweathermap.org/forecast to acquire the data
and return it to the client, as such your application acts as an intermediary.

**Step 2** You will need to sign up to acquire an API key to the openweathermap.org site.

**Step 3** The specific URL you will access to get the information should be http://api.openweathermap.org/data/2.5/forecast?q=[INSERT CITY]&mode=json&appid=[INSERT API ID]

**Step 4** For this task you can use ClientBuilder.newClient() method from JAX-RS. You can get familiar with
its use although this will be cover in class before the submission deadline.

**Example:**
Input in your browser:
http://api.openweathermap.org/data/2.5/forecast?q=DUBLIN&mode=json&appid=Xj667TMlp4topMGN
