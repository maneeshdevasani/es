/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdac.enrollmentstation.security;


import com.cdac.enrollmentstation.logging.ApplicationLog;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.util.ASN1Dump;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author boss
 */
public class HextoASNFormat {

    //For Application Log
    private static final Logger LOGGER = ApplicationLog.getLogger(HextoASNFormat.class);
    Handler handler;

    public HextoASNFormat() {
        //this.handler = appLog.getLogger();
        // LOGGER.addHandler(handler);
    }


    public static void main(String args[]) {
//         String DatafromNaval = "MIGmBGJDQzc3MzM4QTAxMDAwMzAwMDMwMDAwMDAwQzAyMDVBNUE0MDAxOTAwMjAwMDRCNjM2MzY2MzYzM0ZGMzc3MTc3MDE3MTIyNzcwNTE2MDcwMDAwNzMyNjA1RTc1NTIxMDIxMRYCODEWCDAxMDExOTkxFggwMTE=";
//         
//         String DatafromNaval1 = "MIGmBGJDQzc3MzM4QTAxMDAwMzAwMDMwMDAwMDAwQzAyMDVBNUE0MDAxOTAwMjAwMDRCNjM2MzY2MzYzM0ZGMzc3MTc3MDE3MTIyNzcwNTE2MDcwMDAwNzMyNjA1RTc1NTIxMDIxMRYCODEWCDAxMDExOTkxFggwMTE=";
//         String DatafromNaval2 = "MDIwMjECAW8WC0luZGlhbiBOYXZ5FgVUZWNoTQIBAQIBKxMFU2FoaWwWBG1hcms=";
//        String DatafromNaval3 = "MIGmBGJDQzc3MzM4QTAxMDAwMzAwMDMwMDAwMDAwQzAyMDVBNUE0MDAxOTAwMjAwMDRCNjM2MzY2MzYzM0ZGMzc3MTc3MDE3MTIyNzcwNTE2MDcwMDAwNzMyNjA1RTc1NTIxMDIxMRYCODEWCDAxMDExOTkxFggwMTE=";
//        String DatafromNaval4 = "MDIwMjECAW8WC0luZGlhbiBOYXZ5FgVUZWNoTQIBAQIBKxMFU2FoaWwWBG1hcmsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=";
//         
//         String csn = "zHczigEAAwADAAAADAIFpaQAGQAgAEtjY2Y2M/83cXcBcSJ3BRYHAABzJgXnVSECEQ==";
//          //String csn = "83cXcBcSJ3BRYHAABzJgXnVSECEQ==";
//          
//         byte[] decodedDatafromNaval = Base64.getDecoder().decode(DatafromNaval);
//         byte[] decodedDatafromNaval1 = Base64.getDecoder().decode(DatafromNaval1);
//         byte[] decodedDatafromNaval2 = Base64.getDecoder().decode(DatafromNaval2);
//         byte[] decodedDatafromNaval3 = Base64.getDecoder().decode(DatafromNaval3);
//         byte[] decodedDatafromNaval4 = Base64.getDecoder().decode(DatafromNaval4);
//         

        String testdata = "MIIBbH+CAWRSazFTQURBek1BQUFBQUVKQUFFQUFBQUErdi8vLy8vLy8vLy8vd0FBQUFBQUFBQUFBTVVBeFFBQk9RR0ZZQ1NBakFEWnVtUkFuQUQ1eDJSQXFRRUx4MlNBdWdFTFEyU0Fod0VSdkdSQVJBRDFzR1JBZ2dCZG1tUkFXUUVydEdTQWRnQlFtR1NBMVFCTGdtU0FXd0JHRm1SQVhRRlN3MlNBdkFEZnUyU0FhUUN4S0dTQWxRRU14R1NBb2dFUlJXU0FqQUIyRVdTQS9BRG1iRTFBK1FFTjNsbEFVUUJtR21TQWdBRkZ6MlJBcndBN2ltUkFzUUZnUjJTQVl3QXdFMlJBc1FDbm1XUkF6Z0R6eW1SQTRRQ3JmV1JBM1FDYjltUkFzUUJyaldSQS9RRDRaVkdBS3dDeUtXUkFpUUJOREdTQkdnQ2NiRlpBMmdCRittUkFoZ0ZlVDJTQWhnRndYbVFBQUE9PRYCUkw=";
        //For Reading Certificate
        String Data1 = "MYIG1TCCA04wggI2oAMCAQICAQMwDQYJKoZIhvcNAQELBQAwXjELMAkGA1UEBhMCSU4xCzAJBgNVBAgTAlVQMQ4wDAYDVQQHEwVOT0lEQTENMAsGA1UEChMEQ0RBQzELMAkGA1UECxMCRVMxFjAUBgNVBAMMDUFGU0E=";
        String Data2 = "Q19ST09UX0NBMB4XDTIwMTAyOTA4MjEwMFoXDTMwMTAzMDA4MjEwMFowVzELMAkGA1UEBhMCSU4xCzAJBgNVBAgTAlVQMQ4wDAYDVQQHEwVOT0lEQTENMAsGA1UEChMEQ0RBQzELMAkGA1UECxMCRVMxDzANBgNVBAM=";
        String Data3 = "EwZCRUwtQ0EwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDJKsFWBzqaAQG5ljhqmFQkNnE0e7YcpvdBgpAM1OcZBRobjIG/zgeeg0biKTLP3fYB1p29OVl7yjyR7AgLQtGIJfGDFse4B/9HO7HtHsGc7wc=";
        String Data4 = "wWCQqV5YcZaL4gpEgZdnzn/K9iDy9NcVySUR/j3UPgskMrQrErF8gfEWN8veHdm+6CvOueElNSNYZ6r6DlnXTR4QId8VLcm33GhPtCFERRHe4ZvZ1L3JVgmdDTZYL4Fl7bc2a5D0sYtAV1AaJZQ/oABADpza3VlbgGE=";
        String Data5 = "2hH/PyGInGYVEIWm1fsoKPbDgqRyYVgCB2/is6JiZCSiC7o4Jh5j2a16KxkZilmGeUXcHJMCAwEAAaMeMBwwDAYDVR0TBAUwAwEB/zAMBgNVHQ8EBQMDB7eAMA0GCSqGSIb3DQEBCwUAA4IBAQBcfoNKMSeWyW/ovY8=";
        String Data6 = "f1rStBXSOnBUJDzguW26apqUVwSXJzXauizNvc3dXrvZc2KSe7XScuhbpPoErumqhHy9Lt/OW0c170aNmnaC7aGpvz3GDOKtP/+U4DhyZCQXrNoY9f2DaVJqn3kRh8gGoJjW8zxEbUpA59FDrCfYYxjcNk4ZZuV5jAw=";
        String Data7 = "dm37ztoj3X51FokHLWwKR0q4l50OCl4ER4QcqxUvwdrpb2QjTl3p/kuWN2lnnYGwO+hmdBNaOu0HO9jOZcDQhLqL5meU3xszeU8SKQk9hXNjAirhuZVnieeDaKr0KyLqAuWh39gMX+LPR3QZji3mgDqAaV1/iKoBtlU=";
        String Data8 = "MIIDfzCCAmegAwIBAgIBMTANBgkqhkiG9w0BAQsFADBXMQswCQYDVQQGEwJJTjELMAkGA1UECBMCVVAxDjAMBgNVBAcTBU5PSURBMQ0wCwYDVQQKEwRDREFDMQswCQYDVQQLEwJFUzEPMA0GA1UEAxMGQkVMLUNBMB4=";
        String Data9 = "Fw0yMTA5MTAwNDQyMDBaFw0yMjA5MTAwNDQyMDBaMIGSMQswCQYDVQQGEwJJTjEQMA4GA1UEChMHQUZTQUMgTzERMA8GA1UECxMIQUZTQUMgT1UxSTBHBgNVBAMTQDczNERDQzc0MjQ4Q0UxQUU3NjJDRTBCNTNBQ0Q=";
        String Data10 = "ODc4NTc3QkI3MEYxQ0I2NjlDRjNCOTY0OUI5MERGQTNFMTE2MRMwEQYDVQQMEwpTWVNURU1DRVJUMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiNASKSRYZqAG1F8KcIBrxZ17O0AsWQDfPQauPkWKnqo=";
        String Data11 = "UXBmVs4KPtVcAvVcZOO5TbvevGk8FTV+8NF3jdu0Mj0Ibt6ddmDbi3tb2RQZhXH3SY6M6b/onLxvbOmP/HCxQXr2/pPS+BIEw3EUcYd3KxM7ABb8Z0w5nocJ/z3HHbxjZ2XEGb2Dbja9YT/EApkj7SWy5J0WTYzMbuI=";
        String Data12 = "2Sqm67zI+qu7CRTYPdHD5aAaXecfQ9g7Wmk1JeGtBYq2Bk/Bno7F5d3+89wEDQ1vZ0ToVeuPppybw4rQ/VbvnNMHHk0UNLMvzGeIu6srGKkrM3fxHW5s06CVOW4StPgFSCeA+lY/AgMBAAGjGjAYMAkGA1UdEwQCMAA=";
        String Data13 = "MAsGA1UdDwQEAwIEsDANBgkqhkiG9w0BAQsFAAOCAQEAvNUUeoF2t/oVr64dadaxkpzlsrPDQkOMcg9L+e3+mCTTfVnDbH46MXZ4gnDJFucdo5UtOPPdT4Wl+PllyEeD4zI/meCEI8yotH+XOxuv4f+D/EoezSBMkbM=";
        String Data14 = "/NbLSt0Y8BvsCxTWktIzcZebCVTFF4w58W9QDSecKmE/y3yzMmU+3AVgQEVg/kDOmrBWPbSpV55OXovQ+w8Gbu3R6eOkUECNa6CEz2hH7bluaRIsSpSvVzMvH/WFrvMEshCu/mgK7Gbf/2GMbSiGCDoLL6sDxy2ypFI=";
        //String Data15 = "9RmvlFR4SjXOsG6oiBvMEbhxoLWRu3gLYhEqE6gs5JCz7H2jsKMhXbPtekgNAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA=";
        String Data15 = "9RmvlFR4SjXOsG6oiBvMEbhxoLWRu3gLYhEqE6gs5JCz7H2jsKMhXbPtekgN";

        //9RmvlFR4SjXOsG6oiBvMEbhxoLWRu3gLYhEqE6gs5JCz7H2jsKMhXbPtekgNAAA=

        byte[] decodedCert1 = Base64.getDecoder().decode(Data1);
        byte[] decodedCert2 = Base64.getDecoder().decode(Data2);
        byte[] decodedCert3 = Base64.getDecoder().decode(Data3);
        byte[] decodedCert4 = Base64.getDecoder().decode(Data4);
        byte[] decodedCert5 = Base64.getDecoder().decode(Data5);
        byte[] decodedCert6 = Base64.getDecoder().decode(Data6);
        byte[] decodedCert7 = Base64.getDecoder().decode(Data7);
        byte[] decodedCert8 = Base64.getDecoder().decode(Data8);
        byte[] decodedCert9 = Base64.getDecoder().decode(Data9);
        byte[] decodedCert10 = Base64.getDecoder().decode(Data10);
        byte[] decodedCert11 = Base64.getDecoder().decode(Data11);
        byte[] decodedCert12 = Base64.getDecoder().decode(Data12);
        byte[] decodedCert13 = Base64.getDecoder().decode(Data13);
        byte[] decodedCert14 = Base64.getDecoder().decode(Data14);
        byte[] decodedCert15 = Base64.getDecoder().decode(Data15);
        byte[] decodedCert16 = Base64.getDecoder().decode(testdata);


        // String values = (DatatypeConverter.printHexBinary(decodedCert1) + DatatypeConverter.printHexBinary(decodedCert2) + DatatypeConverter.printHexBinary(decodedCert3) + DatatypeConverter.printHexBinary(decodedCert4) + DatatypeConverter.printHexBinary(decodedCert5) + DatatypeConverter.printHexBinary(decodedCert6) + DatatypeConverter.printHexBinary(decodedCert7) + DatatypeConverter.printHexBinary(decodedCert8) + DatatypeConverter.printHexBinary(decodedCert9) + DatatypeConverter.printHexBinary(decodedCert10) + DatatypeConverter.printHexBinary(decodedCert11) + DatatypeConverter.printHexBinary(decodedCert12) + DatatypeConverter.printHexBinary(decodedCert13) + DatatypeConverter.printHexBinary(decodedCert14) + DatatypeConverter.printHexBinary(decodedCert15));
        //String values = "3230323102016F160B496E6469616E204E6176791605546563684D02010102012B130650616E6B616A16046D61726B000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";;
        //String values = "3081D7046243433737333338413031303030333030303330303030303030433032303541354134303031393030323030303444363336333636333633334646333737313737303137313232373730353136303730303030373332363035453735353231303231311602383202010002012B130556696D616C02011816073138323633354116065569643139320201000201000201001608303130313139393116000201001608303131303230323102010002010002016F160B496E6469616E204E6176791605546563684D020101160013000201001600020100";
        //String decodedStringFromNaval1 = "3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";
        String values = (DatatypeConverter.printHexBinary(decodedCert16));
        //String values = "318206D53082034E30820236A003020102020103300D06092A864886F70D01010B0500305E310B300906035504061302494E310B3009060355040813025550310E300C060355040713054E4F494441310D300B060355040A130443444143310B3009060355040B130245533116301406035504030C0D41465341435F524F4F545F4341301E170D3230313032393038323130305A170D3330313033303038323130305A3057310B300906035504061302494E310B3009060355040813025550310E300C060355040713054E4F494441310D300B060355040A130443444143310B3009060355040B13024553310F300D0603550403130642454C2D434130820122300D06092A864886F70D01010105000382010F003082010A0282010100C92AC156073A9A0101B996386A9854243671347BB61CA6F74182900CD4E719051A1B8C81BFCE079E8346E22932CFDDF601D69DBD39597BCA3C91EC080B42D18825F18316C7B807FF473BB1ED1EC19CEF07C16090A95E5871968BE20A44819767CE7FCAF620F2F4D715C92511FE3DD43E0B2432B42B12B17C81F11637CBDE1DD9BEE82BCEB9E12535235867AAFA0E59D74D1E1021DF152DC9B7DC684FB421444511DEE19BD9D4BDC956099D0D36582F8165EDB7366B90F4B18B4057501A25943FA000400E9CDADD595B8061DA11FF3F21889C66151085A6D5FB2828F6C382A472615802076FE2B3A2626424A20BBA38261E63D9AD7A2B19198A59867945DC1C930203010001A31E301C300C0603551D13040530030101FF300C0603551D0F0405030307B780300D06092A864886F70D01010B050003820101005C7E834A312796C96FE8BD8F7F5AD2B415D23A7054243CE0B96DBA6A9A945704972735DABA2CCDBDCDDD5EBBD97362927BB5D272E85BA4FA04AEE9AA847CBD2EDFCE5B4735EF468D9A7682EDA1A9BF3DC60CE2AD3FFF94E03872642417ACDA18F5FD8369526A9F791187C806A098D6F33C446D4A40E7D143AC27D86318DC364E1966E5798C0C766DFBCEDA23DD7E751689072D6C0A474AB8979D0E0A5E0447841CAB152FC1DAE96F64234E5DE9FE4B963769679D81B03BE86674135A3AED073BD8CE65C0D084BA8BE66794DF1B33794F1229093D857363022AE1B9956789E78368AAF42B22EA02E5A1DFD80C5FE2CF4774198E2DE6803A80695D7F88AA01B6553082037F30820267A003020102020132300D06092A864886F70D01010B05003057310B300906035504061302494E310B3009060355040813025550310E300C060355040713054E4F494441310D300B060355040A130443444143310B3009060355040B13024553310F300D0603550403130642454C2D4341301E170D3231303931303034353530305A170D3232303931303034353530305A308192310B300906035504061302494E3110300E060355040A13074146534143204F3111300F060355040B13084146534143204F5531493047060355040313403737393936323438313538373246414543424636413834323943314342393045354437323843443743373642433133313946363032333141364230394531423731133011060355040C130A53595354454D4345525430820122300D06092A864886F70D01010105000382010F003082010A02820101008E2AD3907C6F31EC4D7B1785757CAD4511CE0692A509B82B6CA0F3643CAE690271080CF67B6D27EE8EB21830B202EA4C75ED9648931640DD04AAAA48B0BB6ABEC81DA5557E03C117B4C3CE7EE6D5DF439A936892BDD9BFF0A9E1E41D94B8A40E1EE42CA8C029AD4ADA716ECA146825E909D8915C1BA45F47EF9E9802CD1F5D4814ADB9AA4A78D09BCA708252D977BE61DE7A0BFD09B91E259F3C5D35462FDC6AAAC0CB5C4F943757E24302247686B8582C033727DC9D0E8025ACBB9AD0D85C09A9163F4CC415C744E116AC3CEA4A8D79416B12B136AE061D77EA7B39AD69C2A051E093618362D388074BA2629816620A452E21C292324DECB1DC36630528A1730203010001A31A301830090603551D1304023000300B0603551D0F0404030204B0300D06092A864886F70D01010B050003820101007B7F6F99247FEF8063E52C61D3CC7CB4B6B3E7662E778350F85FBF0416C24BCA28B340D25E43F75B64D11DE7FB6E1A17A7D6EA7B1054BDE79C21E10BCA61A7CFF8F45EFE0D082BF0C466A2F106D06966D5023073DACC779058DDCFB2D40177E979728D7285F84AEE34E209944A84C06814811102E88A380AA3554FCFAD625D1E636D3D35CF3B0859C51705D8F46C8B9A69B891E06148D03F1C25F82249D7917B94D4A467C97B7BA7C0B5DD8E87CB9B99181B0782C7ECD2B34FA76B13A3479818710B645988C07F7B6AE1F4D5E1894E679AD39C0C861C2EA889AF969FE096108AA72B04957B88B6295B62C07A47BD8696379F147EEF0E67A4FC9BDA1B28429A47";
        System.out.println("values:::" + values);
        System.out.println("Hex lenghth::::" + values.length());

        //Encode the values to base64
        byte[] result = DatatypeConverter.parseHexBinary(values);
        String encodedbase64CertRes = Base64.getEncoder().encodeToString(result);
        System.out.println("encodedbase64Res:::" + encodedbase64CertRes);

//          String encodedbase64Cert = Base64.getEncoder().encodeToString(values.getBytes());
//          System.out.println("encodedbase64Dynamic:::"+encodedbase64Cert);
//          System.out.println("length:::"+encodedbase64Cert.length());


//         byte[] decodedcsn = Base64.getDecoder().decode(csn);
//         //String decodedString = new String(decodedDatafromNaval);
//         System.out.println("Decoded String CSN :::::" +DatatypeConverter.printHexBinary(decodedcsn));
//         System.out.println("Decoded String CSN :::::" +DatatypeConverter.printHexBinary(decodedcsn).toString());
//         System.out.println("Decoded String Data"+DatatypeConverter.printHexBinary(decodedDatafromNaval));
//         System.out.println("Decoded String Data1"+DatatypeConverter.printHexBinary(decodedDatafromNaval1));
//         System.out.println("Decoded String Data2"+DatatypeConverter.printHexBinary(decodedDatafromNaval2));
//         System.out.println("Decoded String Data4"+DatatypeConverter.printHexBinary(decodedDatafromNaval4));
        //String values = (DatatypeConverter.printHexBinary(decodedDatafromNaval3) + DatatypeConverter.printHexBinary(decodedDatafromNaval4));
        //String values = (DatatypeConverter.printHexBinary(decodedDatafromNaval4));
        //System.out.println("values::"+values);
        //String values = "3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";

        //String values = "3081A604624343373733333841303130303033303030333030303030303043303230354135413430303139303032303030344236333633363633363333464633373731373730313731323237373035313630373030303037333236303545373535323130323131160238311608303130313139393116083031313230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";
        //3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B


        //String values = DatatypeConverter.printHexBinary(decodedcsn);

        // System.out.println("--"+values);
        // dump TLV form
        //ByteArrayInputStream bufferIn = new ByteArrayInputStream(com.yafred.asn1.runtime.BERDumper.bytesFromString(values));


        ASN1InputStream bIn = new ASN1InputStream(new ByteArrayInputStream(com.yafred.asn1.runtime.BERDumper.bytesFromString(values)));


        ASN1Primitive obj = null;

        try {
            obj = (ASN1Primitive) bIn.readObject();
            System.out.println(ASN1Dump.dumpAsString(obj));
            bIn.close();
        } catch (IOException ex) {
            Logger.getLogger(HextoASNFormat.class.getName()).log(Level.SEVERE, null, ex);
        }


//        ASN1Sequence sequence = null;
//       
//        
//        String asn1sequence = sequence.getInstance(obj).toString();
//        String[] asnsequencearr = asn1sequence.split(",");
//        
//        System.out.println("SSS"+asn1sequence );
//        System.out.println("card id "+ asnsequencearr[1]);


    }

    public String getDecodedCSN(String csnValue) {
        byte[] decodedcsn = Base64.getDecoder().decode(csnValue);
        String decodedCsnValue = DatatypeConverter.printHexBinary(decodedcsn);
        return decodedCsnValue;
    }

    public String getContractorIdfromASN(String decodedResponseValue) {


        System.out.println("DECODED STRING AT HEXTOASN " + decodedResponseValue);

        //String decodedStringFromNaval1 = "3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";
        //String decodedResponseValue1 = "3081D7046243433737333338413031303030333030303330303030303030433032303541354134303031393030323030303444363336333636333633334646333737313737303137313232373730353136303730303030373332363035453735353231303231311602383202010002012B130556696D616C02011816073138323633354116065569643139320201000201000201001608303130313139393116000201001608303131303230323102010002010002016F160B496E6469616E204E6176791605546563684D02010116001300020100160002010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String decodedResponseValue1 = "3081DB046243433737333338413031303030333030303330303030303030433032303541354134303031393030323030303444363336333636333633334646333737313737303137313232373730353136303730303030373332363035453735353231303231311602383202010002012B130556696D616C020118160731383236333541160A323631324153462D30310201000201000201001608303130313139393116000201001608303131303230323102010002010002016F160B496E6469616E204E6176791605546563684D02010116001300020100160002010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

        // Convert the String to ASN Sequence
        ASN1InputStream datafromNavalInputStream = new ASN1InputStream(new ByteArrayInputStream(com.yafred.asn1.runtime.BERDumper.bytesFromString(decodedResponseValue)));
        ASN1Primitive obj = null;
        String[] asnsequencearr = new String[0];
        try {
            obj = (ASN1Primitive) datafromNavalInputStream.readObject();
            System.out.println(ASN1Dump.dumpAsString(obj));

            //Get theASN Data Sequence       
            ASN1Sequence sequence = null;

            String asn1sequence = sequence.getInstance(obj).toString();
            asnsequencearr = asn1sequence.split(",");

            System.out.println("SSS" + asn1sequence);
            System.out.println("Chip Serial Number" + asnsequencearr[0]);


            System.out.println("Card Number" + asnsequencearr[1]);
            System.out.println("contractor ID id  From HexToASN" + asnsequencearr[7]);


            datafromNavalInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(HextoASNFormat.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.log(Level.INFO, ex + "IOException:");
        }

        return asnsequencearr[7];
    }

    public String getContractorNamefromASN(String decodedResponseValue) {


        System.out.println("DECODED STRING AT HEXTOASN " + decodedResponseValue);

        //String decodedStringFromNaval1 = "3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";
        //String decodedResponseValue1 = "3081D7046243433737333338413031303030333030303330303030303030433032303541354134303031393030323030303444363336333636333633334646333737313737303137313232373730353136303730303030373332363035453735353231303231311602383202010002012B130556696D616C02011816073138323633354116065569643139320201000201000201001608303130313139393116000201001608303131303230323102010002010002016F160B496E6469616E204E6176791605546563684D02010116001300020100160002010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        String decodedResponseValue1 = "3081DB046243433737333338413031303030333030303330303030303030433032303541354134303031393030323030303444363336333636333633334646333737313737303137313232373730353136303730303030373332363035453735353231303231311602383202010002012B130556696D616C020118160731383236333541160A323631324153462D30310201000201000201001608303130313139393116000201001608303131303230323102010002010002016F160B496E6469616E204E6176791605546563684D02010116001300020100160002010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        // Convert the String to ASN Sequence
        ASN1InputStream datafromNavalInputStream = new ASN1InputStream(new ByteArrayInputStream(com.yafred.asn1.runtime.BERDumper.bytesFromString(decodedResponseValue)));
        ASN1Primitive obj = null;
        String[] asnsequencearr = new String[0];
        try {
            obj = (ASN1Primitive) datafromNavalInputStream.readObject();
            System.out.println(ASN1Dump.dumpAsString(obj));

            //Get theASN Data Sequence       
            ASN1Sequence sequence = null;

            String asn1sequence = sequence.getInstance(obj).toString();
            System.out.println("ASN1Sequence:::" + asn1sequence);
            asnsequencearr = asn1sequence.split(",");

            datafromNavalInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(HextoASNFormat.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.log(Level.INFO, ex + "IOException:");
        }


        return asnsequencearr[4];
    }

    public String getContractorId(String responseValue1, String responseValue2) {

        //System.out.println("RESPONE AT HEXTOASN "+responseValue);
        byte[] decodedDatafromNaval1 = Base64.getDecoder().decode(responseValue1);
        byte[] decodedDatafromNaval2 = Base64.getDecoder().decode(responseValue2);
        String decodedStringFromNaval = DatatypeConverter.printHexBinary(decodedDatafromNaval1) + DatatypeConverter.printHexBinary(decodedDatafromNaval2);

        System.out.println("DECODED STRING AT HEXTOASN " + decodedStringFromNaval);

        //String decodedStringFromNaval1 = "3081A60462434337373333384130313030303330303033303030303030304330323035413541343030313930303230303034423633363336363336333346463337373137373031373132323737303531363037303030303733323630354537353532313032313116023831160830313031313939311608303131303230323102016F160B496E6469616E204E6176791605546563684D02010102012B1305536168696C16046D61726B";

        // Convert the String to ASN Sequence
        ASN1InputStream datafromNavalInputStream = new ASN1InputStream(new ByteArrayInputStream(com.yafred.asn1.runtime.BERDumper.bytesFromString(decodedStringFromNaval)));
        ASN1Primitive obj = null;
        String[] asnsequencearr = new String[0];
        try {
            obj = (ASN1Primitive) datafromNavalInputStream.readObject();
            System.out.println(ASN1Dump.dumpAsString(obj));

            //Get theASN Data Sequence
            ASN1Sequence sequence = null;

            String asn1sequence = sequence.getInstance(obj).toString();
            asnsequencearr = asn1sequence.split(",");

            System.out.println("SSS" + asn1sequence);
            System.out.println("Card Number  From HexToASN" + asnsequencearr[0]);
            System.out.println("DOB  From HexToASN" + asnsequencearr[1]);
            System.out.println("contractor ID id  From HexToASN" + asnsequencearr[8]);
            datafromNavalInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(HextoASNFormat.class.getName()).log(Level.SEVERE, null, ex);
            LOGGER.log(Level.INFO, ex + "IOException:");
        }


        return asnsequencearr[8];
    }

    public String getEncodedCert(String decodedCert) {
        //Encode the values to base64
        byte[] resultcert = DatatypeConverter.parseHexBinary(decodedCert);
        String encodedbase64CertResult = Base64.getEncoder().encodeToString(resultcert);
        System.out.println("encodedbase64Res:::" + encodedbase64CertResult);
        return encodedbase64CertResult;

    }

}