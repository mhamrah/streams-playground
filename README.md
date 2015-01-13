# streams-playground #

## Notes

I dislike the maven directory layout, and prefer Go's simplified path model with tests next to classes. This project modifies build.sbt to search for source files in different places than the default.

### Distributions

To create a distribution via [SBT Native Packager](https://github.com/sbt/sbt-native-packager) use ```universal:packageZipTarball``` or ```universal:stage``` for a simple shell script.
