# Firebase-Deeplink-Statistics

This small App gets the statistics for your Dynamic Links that you configured on Google Firebase.

## How to run
First you need a appropriate service-account on Google Cloud to have the permission to get the statistics.
Save the account information in a local file `service-account.json` in the root of this app.

## Configure links

Edit the `dynamic-links.yml` to configure which statistics you want to get:

```yaml
# This gets the statistics for the last 7 days:
days: 7

# List all the links of interest:
links:
  - https://suva.page.link/testApptiva
  - https://suva.page.link/otherLink
``` 

Run the app with following command:

Windows:

```shell script
gradlew.bat run
```

Mac, Linux:

```shell script
./gradlew run
```

## More information

The API documentation from Google: https://firebase.google.com/docs/reference/dynamic-links/analytics