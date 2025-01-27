# POIFormulaExplorer

## Table of Contents
1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [How to Build and Run](#how-to-build-and-run)
    - [Step 1: Build the Project](#step-1-build-the-project)
    - [Step 2: Run the Application](#step-2-run-the-application)
4. [Example Outputs](#example-outputs)
    - [POI version 5.1.0](#for-poi-version-510)
    - [POI version 4.1.2](#for-poi-version-412)

**POIFormulaExplorer** is a utility that lists supported and unsupported Excel formulas/functions for a given version of Apache POI, including functions from the Analysis ToolPak.

## Features
- Displays supported and unsupported functions for any Apache POI version.
- Includes functions from the Analysis ToolPak.

## Prerequisites
- Java 11
- Apache Maven

## How to Build and Run

### Step 1: Build the Project
To build the project for a specific Apache POI version, run the following Maven command, replacing `poiversion` with the desired POI version (e.g., 5.1.0 or 4.1.2):

```bash
mvn clean install "-Dpoi.version=poiversion"
```
Example:
```bash
mvn clean install "-Dpoi.version=5.1.0"
```

### Step 2: Run the Application
After building the project, you can run it using the following command:


```bash
java -cp target/SupportedFunctions-1.0-SNAPSHOT.jar org.example.SupportedFunctions
```

### Example outputs:
### For POI version 5.1.0:
```yaml
INFO  org.example.SupportedFunctions - Apache POI Version: 5.1.0
INFO  org.example.SupportedFunctions - Supported Functions: ABS, ACOS, ACOSH, ...
INFO  org.example.SupportedFunctions - Not Supported Functions: ABSREF, APP.TITLE, ...
INFO  org.example.SupportedFunctions - Analysis ToolPak Functions: AVERAGEIFS, BIN2DEC, ...
```
### For POI version 4.1.2:
```yaml
INFO  org.example.SupportedFunctions - Apache POI Version: 4.1.2
INFO  org.example.SupportedFunctions - Supported Functions: ABS, ACOS, ACOSH, ...
INFO  org.example.SupportedFunctions - Not Supported Functions: ABSREF, APP.TITLE, ...
INFO  org.example.SupportedFunctions - Analysis ToolPak Functions: BIN2DEC, COMPLEX, ...
```
