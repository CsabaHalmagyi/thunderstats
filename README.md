# Thunderstats

A Spring Boot app that creates email statistics from .eml files downloaded from Thunderbird.

![Screenshot1](/documentation/thunderstats1.png)

## What stats can this app generate from the data?
1. Number of emails by day (sent/received) IE: On Mondays you sent 200 emails and received 340
2. Number of emails by month (sent/received)
3. Number of emails by year (sent/received)
4. Number of emails by hour (sent/received)
5. Top 5 people you sent emails to
6. Top 5 email addresses you received emails from



## How to use it:
I. Export your emails from Thunderbird in .eml format  
II. Clone the app and start it  
III. Visit http://localhost:8080/thunderstats  
IV. Point the app to the directory you have the .eml files and click the "Show some stats!" button




#### I. Export your emails from Thunderbird in .eml format:
1. Create a folder on your local drive
2. Open your Thunderbird app and select your inbox folder. Then click an email and select all (ctrl + A). Then right click on the selected emails and click Save as (see picture attached)
![Screenshot1](/documentation/export_emails.png)
3. Save the emails in the directory that you just created




#### II. Clone the app and start it

#### III. Visit http://localhost:8080/thunderstats

#### IV. Point the app to the directory you have the .eml files and click the "Show some stats!" button
