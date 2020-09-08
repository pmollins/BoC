# BoC

Here is my submission for the role at the Bank of Canada.

This can be run from the command line by:
`./gradlew bootRun` in the root folder.

Tests can be run using gradle by: `./gradlew test` in the root folder of the project.

Upon filtering the front-end reloads the entire page, with more experience with Thymeleaf (which I had none),
this would be presented with a series of templates.  I experimented and created a fragment
for the table rendering.

The front-end is functional, but it is not foolproof as it is possible to specify a date range that is 
invalid.

The `error.html` page is *VERY BASIC*

The unit tests are sparse, but tests for the `ClimateService.java` have their basic framework

 