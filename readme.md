# Mendix XsltConnector

The XsltConnector contains a microflow action that you can use to transform XML with
XSLT templates. This may be useful if your XML contains constructs not supported by
the Mendix import mapper.

## Introduction

XML document can be transformed using XSLT stylesheets. There are many use cases for this,
e.g., generating html documentation or transforming xml into a format that you can read.

## Usage

The *Transform XML using XSLT stylesheet* microflow action takes the following input:
* XML string - string containing an xml document. This may be the output of a webservice call.
* XSLT stylesheet string - string containing the XSLT stylesheet to be applied.

The test module contains a number of examples described in the following sections.

### Xslt Identity transformation

The identity transformation example takes an xml string as input and returns itself as output.

 ![Identity transform][2]

The following xslt stylesheet is used:

    <xsl:stylesheet
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
      version="1.0">

      <xsl:template match="@* | node()">
        <xsl:copy>
          <xsl:apply-templates select="@* | node()"/>
        </xsl:copy>
      </xsl:template>

      <xsl:template match="root/*">
        <action>
          <xsl:apply-templates/>
        </action>
      </xsl:template>

    </xsl:stylesheet>


### Json transformation

Using the xslt sheet described on here: [Convert XML to JSON using XSLT][1] we can convert
an xml document to JSON. The microflow TestCallWsToJson illustrates how you can use this
in combination with a JSON import mapping.

 ![JSON transform][3]

## Development


## Change history

* 0.1 - 2016-july-09
  * Implemented XSLT transform action

 [1]: https://www.bjelic.net/2012/08/01/coding/convert-xml-to-json-using-xslt/
 [2]: docs/images/mf_identity_transform.png
 [3]: docs/images/mf_json_transform.png