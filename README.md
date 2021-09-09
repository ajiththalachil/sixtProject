# Response Comparator:

Solution for comparing response body's of two different requests.
(Run Main class - **comparator.CompareJsonResponses**)

**NOTE: Project needs Java 8 and Maven installed in the System.**


1.HTTPConnection and Requests are handled using RestAssured library.

2.Input files (File1.txt and File2.txt) are placed in the src/main/resources.

3.custom methods for API call and response reading is in utilities.ReqUtils.

Execute:
--------

1.Do 'mvn clean install' either from IDE or via cmd.

2.Run comparator.CompareJsonResponses.

3.Results are printed in console.

NOTE:We can include additional requests in the File1.txt and File2.txt for comparison.
    (Currently there are 10 requests each in the input files)
