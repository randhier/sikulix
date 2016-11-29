## USAGE ##

## Restrictions
### Required ENV variables
SPOTIFY_USER = Spotify user name
SPOTIFY_PASSWORD = Spotify user password
## Spotify is installed and connect to DB/backend
## Spotify is logged out of any user (I tried to find a way to launch in new secession but could not)

## Installation
mvn install

## Run Tests (uses TestNG)
mvn test


## Mute Test
A mute test seemed the logical choice after the play test.
Without control of test data the mute feature was easiest to write.
Debated whether to use current track bar as another pageobject but due to time constraits did not.

## Notes
Control of a test environment where the data could be fixtured and then deleted would have been best.
It would have provided the following:
* A new user could be create/inserted prior to all tests and then deleted.
* New user will not have any existing playlists so creation of playlists can be done without fear of existing.
* Able to fixture a playlist and then verify songs on UI.
* Searching a custom fixtured song and verifying artist info, etc.
* Search for non-existing artist/song.
* Search for a string that matches artist, song and album.

## Improvements
Test on Windows box (I don't have one to verify)
Break out BasePage into more component Class/Objects like LoginPage. Browse, Track bar, etc will have their own classes.
Launching app in new secession where the previous username is not populated in the Username text box. This caused me to
click on the login logo and tab to the usename box instead of looking for an image of an empty one.