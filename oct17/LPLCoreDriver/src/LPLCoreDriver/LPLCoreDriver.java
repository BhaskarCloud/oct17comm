package LPLCoreDriver;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.security.UserAndPassword;

import com.dynatrace.lib.DynaTraceWebDriverHelper;
import com.paulhammant.ngwebdriver.NgWebDriver;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLCoreDriver.java</br> <br>
 * <b> Description: </B> LPL Core Library</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. StartSession: Launches Browser and URL, adjusts any security setting and Initial setup like Download folder setting, Compatibility view etc</br>
 * <br>2. turnOnCompModeIE: To Turn on Compatibility view if the Browser is IE</br>
 * <br>3. closeSession: To Close the Dynatrace or Webservice or Browser Session</br>
 * <br>4. closeAllBrowserProcesses: Method to Close all browser processes running if the executions happens in Farm</br>
 * <br>5. selectCertificate: This function is used to handle login certificates in PRODVIP environment for BranchNet Application</br>
 * <br>6. selectCertAfterMenuNavigation: This function is used to select login certificates in PRODVIP environment after BN menu navigation</br>
 * <br>7. WindowsSecurityLogin: Method to login with Windows credentials</br>
 * <br>8. firefoxExceptionHandler: Method to handle Exception on Page launch in FF</br>
 * @author Aiswarya Srinivasan
 * @since 02-24-2017
 *        </p>
 */
public class LPLCoreDriver {
	public static WebDriver driver;
	public static LPLConfig ocfg;
	public static HashMap<String, String> loginCredentials;
	public static HashMap<String, String> testData;
	public static DateFormat dateFormat;
	public static Date date;
	public static NgWebDriver ngDriver;
	public static String strTestName;
	public static String strReportPath;
	
	//These hard coding have to be removed. For now, we made it as a constant
	public static int intBranchNetProductID = 1;
	public static int intClientWorksProductID = 2;
	public static int intLPLFirmID = 1;
	public static int intProdVIPEnvID = 7;
	public static int intBackOfficeProductID =14;
	public static int intServiceworksProductID = 17;
	
	/**
	 * Launches Browser and URL, adjusts any security setting and Initial setup like Download folder setting, Compatibility view etc
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param None
	 * @return (WebDriver) returns driver control
	 */
	public static WebDriver StartSession() {
		/** Create the Configuration Object */
		ocfg = new LPLConfig(); // Configuration object

		/** Get the CoreConstents Values from the XML */
		LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
		
		/** Browser Capabilities Instance */
		Capabilities capabilities;

		/** Close all the browser and driver instances */
		closeAllBrowserProcesses(ocfg);
		
		/*
		 * ************ Create the report file with date and time stamp. Report
		 * will be stored in "C:\FarmClient\TestDir". *********************
		 */
		LPLCoreReporter.WriteReportHeader();
		
		/** Launch the browser */
		switch (ocfg.getBrowserType().toUpperCase()) {
		//If the Browser is Firefox
		case "FIREFOX":
			//OS - Mac
			if (System.getProperty("os.name").toUpperCase().contains("MAC")) {
				System.out.println("----FireFox driver initialized ---- OS : "
						+ System.getProperty("os.name") + "----------");
				try {
					capabilities = DesiredCapabilities.firefox();
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("dom.ipc.plugins.enabled", false);
					//Set Location to store files after downloading.
					profile.setPreference("browser.download.folderList",2);
					profile.setPreference("browser.download.manager.showWhenStarting",false);
					profile.setPreference("browser.download.dir", lplCoreConstents.DefaultDownloadFolder);
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");
					
					((DesiredCapabilities) capabilities).setCapability(FirefoxDriver.PROFILE, profile);
					driver = new FirefoxDriver(capabilities);
				} catch (Exception x) {
					x.printStackTrace();
					System.out
							.print("Encountered fatal error due to exception "
									+ x.getStackTrace());
					System.exit(1);
				}
			} else { // treat it as Windows
				try {
					System.out
							.println("---------------Firefox driver initialized ---------- OS : "
									+ System.getProperty("os.name")
									+ "----------");
					System.setProperty("webdriver.gecko.driver",lplCoreConstents.WIN_GECKO_DRIVER_PATH);
					DesiredCapabilities dc = DesiredCapabilities.firefox();
					FirefoxProfile profile = new FirefoxProfile();
					profile.setPreference("dom.ipc.plugins.enabled", false);
					//Set Location to store files after downloading.
					profile.setPreference("browser.download.folderList",2);
					profile.setPreference("browser.download.manager.showWhenStarting",false);
					profile.setPreference("browser.download.dir", lplCoreConstents.DefaultDownloadFolder);
					profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.hzn-3d-crossword;video/3gpp;video/3gpp2;application/vnd.mseq;application/vnd.3m.post-it-notes;application/vnd.3gpp.pic-bw-large;application/vnd.3gpp.pic-bw-small;application/vnd.3gpp.pic-bw-var;application/vnd.3gp2.tcap;application/x-7z-compressed;application/x-abiword;application/x-ace-compressed;application/vnd.americandynamics.acc;application/vnd.acucobol;application/vnd.acucorp;audio/adpcm;application/x-authorware-bin;application/x-athorware-map;application/x-authorware-seg;application/vnd.adobe.air-application-installer-package+zip;application/x-shockwave-flash;application/vnd.adobe.fxp;application/pdf;application/vnd.cups-ppd;application/x-director;applicaion/vnd.adobe.xdp+xml;application/vnd.adobe.xfdf;audio/x-aac;application/vnd.ahead.space;application/vnd.airzip.filesecure.azf;application/vnd.airzip.filesecure.azs;application/vnd.amazon.ebook;application/vnd.amiga.ami;applicatin/andrew-inset;application/vnd.android.package-archive;application/vnd.anser-web-certificate-issue-initiation;application/vnd.anser-web-funds-transfer-initiation;application/vnd.antix.game-component;application/vnd.apple.installe+xml;application/applixware;application/vnd.hhe.lesson-player;application/vnd.aristanetworks.swi;text/x-asm;application/atomcat+xml;application/atomsvc+xml;application/atom+xml;application/pkix-attr-cert;audio/x-aiff;video/x-msvieo;application/vnd.audiograph;image/vnd.dxf;model/vnd.dwf;text/plain-bas;application/x-bcpio;application/octet-stream;image/bmp;application/x-bittorrent;application/vnd.rim.cod;application/vnd.blueice.multipass;application/vnd.bm;application/x-sh;image/prs.btif;application/vnd.businessobjects;application/x-bzip;application/x-bzip2;application/x-csh;text/x-c;application/vnd.chemdraw+xml;text/css;chemical/x-cdx;chemical/x-cml;chemical/x-csml;application/vn.contact.cmsg;application/vnd.claymore;application/vnd.clonk.c4group;image/vnd.dvb.subtitle;application/cdmi-capability;application/cdmi-container;application/cdmi-domain;application/cdmi-object;application/cdmi-queue;applicationvnd.cluetrust.cartomobile-config;application/vnd.cluetrust.cartomobile-config-pkg;image/x-cmu-raster;model/vnd.collada+xml;text/csv;application/mac-compactpro;application/vnd.wap.wmlc;image/cgm;x-conference/x-cooltalk;image/x-cmx;application/vnd.xara;application/vnd.cosmocaller;application/x-cpio;application/vnd.crick.clicker;application/vnd.crick.clicker.keyboard;application/vnd.crick.clicker.palette;application/vnd.crick.clicker.template;application/vn.crick.clicker.wordbank;application/vnd.criticaltools.wbs+xml;application/vnd.rig.cryptonote;chemical/x-cif;chemical/x-cmdf;application/cu-seeme;application/prs.cww;text/vnd.curl;text/vnd.curl.dcurl;text/vnd.curl.mcurl;text/vnd.crl.scurl;application/vnd.curl.car;application/vnd.curl.pcurl;application/vnd.yellowriver-custom-menu;application/dssc+der;application/dssc+xml;application/x-debian-package;audio/vnd.dece.audio;image/vnd.dece.graphic;video/vnd.dec.hd;video/vnd.dece.mobile;video/vnd.uvvu.mp4;video/vnd.dece.pd;video/vnd.dece.sd;video/vnd.dece.video;application/x-dvi;application/vnd.fdsn.seed;application/x-dtbook+xml;application/x-dtbresource+xml;application/vnd.dvb.ait;applcation/vnd.dvb.service;audio/vnd.digital-winds;image/vnd.djvu;application/xml-dtd;application/vnd.dolby.mlp;application/x-doom;application/vnd.dpgraph;audio/vnd.dra;application/vnd.dreamfactory;audio/vnd.dts;audio/vnd.dts.hd;imag/vnd.dwg;application/vnd.dynageo;application/ecmascript;application/vnd.ecowin.chart;image/vnd.fujixerox.edmics-mmr;image/vnd.fujixerox.edmics-rlc;application/exi;application/vnd.proteus.magazine;application/epub+zip;message/rfc82;application/vnd.enliven;application/vnd.is-xpr;image/vnd.xiff;application/vnd.xfdl;application/emma+xml;application/vnd.ezpix-album;application/vnd.ezpix-package;image/vnd.fst;video/vnd.fvt;image/vnd.fastbidsheet;application/vn.denovo.fcselayout-link;video/x-f4v;video/x-flv;image/vnd.fpx;image/vnd.net-fpx;text/vnd.fmi.flexstor;video/x-fli;application/vnd.fluxtime.clip;application/vnd.fdf;text/x-fortran;application/vnd.mif;application/vnd.framemaker;imae/x-freehand;application/vnd.fsc.weblaunch;application/vnd.frogans.fnc;application/vnd.frogans.ltf;application/vnd.fujixerox.ddd;application/vnd.fujixerox.docuworks;application/vnd.fujixerox.docuworks.binder;application/vnd.fujitu.oasys;application/vnd.fujitsu.oasys2;application/vnd.fujitsu.oasys3;application/vnd.fujitsu.oasysgp;application/vnd.fujitsu.oasysprs;application/x-futuresplash;application/vnd.fuzzysheet;image/g3fax;application/vnd.gmx;model/vn.gtw;application/vnd.genomatix.tuxedo;application/vnd.geogebra.file;application/vnd.geogebra.tool;model/vnd.gdl;application/vnd.geometry-explorer;application/vnd.geonext;application/vnd.geoplan;application/vnd.geospace;applicatio/x-font-ghostscript;application/x-font-bdf;application/x-gtar;application/x-texinfo;application/x-gnumeric;application/vnd.google-earth.kml+xml;application/vnd.google-earth.kmz;application/vnd.grafeq;image/gif;text/vnd.graphviz;aplication/vnd.groove-account;application/vnd.groove-help;application/vnd.groove-identity-message;application/vnd.groove-injector;application/vnd.groove-tool-message;application/vnd.groove-tool-template;application/vnd.groove-vcar;video/h261;video/h263;video/h264;application/vnd.hp-hpid;application/vnd.hp-hps;application/x-hdf;audio/vnd.rip;application/vnd.hbci;application/vnd.hp-jlyt;application/vnd.hp-pcl;application/vnd.hp-hpgl;application/vnd.yamaha.h-script;application/vnd.yamaha.hv-dic;application/vnd.yamaha.hv-voice;application/vnd.hydrostatix.sof-data;application/hyperstudio;application/vnd.hal+xml;text/html;application/vnd.ibm.rights-management;application/vnd.ibm.securecontainer;text/calendar;application/vnd.iccprofile;image/x-icon;application/vnd.igloader;image/ief;application/vnd.immervision-ivp;application/vnd.immervision-ivu;application/reginfo+xml;text/vnd.in3d.3dml;text/vnd.in3d.spot;mode/iges;application/vnd.intergeo;application/vnd.cinderella;application/vnd.intercon.formnet;application/vnd.isac.fcs;application/ipfix;application/pkix-cert;application/pkixcmp;application/pkix-crl;application/pkix-pkipath;applicaion/vnd.insors.igm;application/vnd.ipunplugged.rcprofile;application/vnd.irepository.package+xml;text/vnd.sun.j2me.app-descriptor;application/java-archive;application/java-vm;application/x-java-jnlp-file;application/java-serializd-object;text/x-java-source,java;application/javascript;application/json;application/vnd.joost.joda-archive;video/jpm;image/jpeg;video/jpeg;application/vnd.kahootz;application/vnd.chipnuts.karaoke-mmd;application/vnd.kde.karbon;aplication/vnd.kde.kchart;application/vnd.kde.kformula;application/vnd.kde.kivio;application/vnd.kde.kontour;application/vnd.kde.kpresenter;application/vnd.kde.kspread;application/vnd.kde.kword;application/vnd.kenameaapp;applicatin/vnd.kidspiration;application/vnd.kinar;application/vnd.kodak-descriptor;application/vnd.las.las+xml;application/x-latex;application/vnd.llamagraphics.life-balance.desktop;application/vnd.llamagraphics.life-balance.exchange+xml;application/vnd.jam;application/vnd.lotus-1-2-3;application/vnd.lotus-approach;application/vnd.lotus-freelance;application/vnd.lotus-notes;application/vnd.lotus-organizer;application/vnd.lotus-screencam;application/vnd.lotus-wordro;audio/vnd.lucent.voice;audio/x-mpegurl;video/x-m4v;application/mac-binhex40;application/vnd.macports.portpkg;application/vnd.osgeo.mapguide.package;application/marc;application/marcxml+xml;application/mxf;application/vnd.wolfrm.player;application/mathematica;application/mathml+xml;application/mbox;application/vnd.medcalcdata;application/mediaservercontrol+xml;application/vnd.mediastation.cdkey;application/vnd.mfer;application/vnd.mfmp;model/mesh;appliation/mads+xml;application/mets+xml;application/mods+xml;application/metalink4+xml;application/vnd.ms-powerpoint.template.macroenabled.12;application/vnd.ms-word.document.macroenabled.12;application/vnd.ms-word.template.macroenabed.12;application/vnd.mcd;application/vnd.micrografx.flo;application/vnd.micrografx.igx;application/vnd.eszigno3+xml;application/x-msaccess;video/x-ms-asf;application/x-msdownload;application/vnd.ms-artgalry;application/vnd.ms-ca-compressed;application/vnd.ms-ims;application/x-ms-application;application/x-msclip;image/vnd.ms-modi;application/vnd.ms-fontobject;application/vnd.ms-excel;application/vnd.ms-excel.addin.macroenabled.12;application/vnd.ms-excelsheet.binary.macroenabled.12;application/vnd.ms-excel.template.macroenabled.12;application/vnd.ms-excel.sheet.macroenabled.12;application/vnd.ms-htmlhelp;application/x-mscardfile;application/vnd.ms-lrm;application/x-msmediaview;aplication/x-msmoney;application/vnd.openxmlformats-officedocument.presentationml.presentation;application/vnd.openxmlformats-officedocument.presentationml.slide;application/vnd.openxmlformats-officedocument.presentationml.slideshw;application/vnd.openxmlformats-officedocument.presentationml.template;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/vnd.openxmlformats-officedocument.spreadsheetml.template;application/vnd.openxmformats-officedocument.wordprocessingml.document;application/vnd.openxmlformats-officedocument.wordprocessingml.template;application/x-msbinder;application/vnd.ms-officetheme;application/onenote;audio/vnd.ms-playready.media.pya;vdeo/vnd.ms-playready.media.pyv;application/vnd.ms-powerpoint;application/vnd.ms-powerpoint.addin.macroenabled.12;application/vnd.ms-powerpoint.slide.macroenabled.12;application/vnd.ms-powerpoint.presentation.macroenabled.12;appliation/vnd.ms-powerpoint.slideshow.macroenabled.12;application/vnd.ms-project;application/x-mspublisher;application/x-msschedule;application/x-silverlight-app;application/vnd.ms-pki.stl;application/vnd.ms-pki.seccat;application/vn.visio;video/x-ms-wm;audio/x-ms-wma;audio/x-ms-wax;video/x-ms-wmx;application/x-ms-wmd;application/vnd.ms-wpl;application/x-ms-wmz;video/x-ms-wmv;video/x-ms-wvx;application/x-msmetafile;application/x-msterminal;application/msword;application/x-mswrite;application/vnd.ms-works;application/x-ms-xbap;application/vnd.ms-xpsdocument;audio/midi;application/vnd.ibm.minipay;application/vnd.ibm.modcap;application/vnd.jcp.javame.midlet-rms;application/vnd.tmobile-ivetv;application/x-mobipocket-ebook;application/vnd.mobius.mbk;application/vnd.mobius.dis;application/vnd.mobius.plc;application/vnd.mobius.mqy;application/vnd.mobius.msl;application/vnd.mobius.txf;application/vnd.mobius.daf;tex/vnd.fly;application/vnd.mophun.certificate;application/vnd.mophun.application;video/mj2;audio/mpeg;video/vnd.mpegurl;video/mpeg;application/mp21;audio/mp4;video/mp4;application/mp4;application/vnd.apple.mpegurl;application/vnd.msician;application/vnd.muvee.style;application/xv+xml;application/vnd.nokia.n-gage.data;application/vnd.nokia.n-gage.symbian.install;application/x-dtbncx+xml;application/x-netcdf;application/vnd.neurolanguage.nlu;application/vnd.na;application/vnd.noblenet-directory;application/vnd.noblenet-sealer;application/vnd.noblenet-web;application/vnd.nokia.radio-preset;application/vnd.nokia.radio-presets;text/n3;application/vnd.novadigm.edm;application/vnd.novadim.edx;application/vnd.novadigm.ext;application/vnd.flographit;audio/vnd.nuera.ecelp4800;audio/vnd.nuera.ecelp7470;audio/vnd.nuera.ecelp9600;application/oda;application/ogg;audio/ogg;video/ogg;application/vnd.oma.dd2+xml;applicatin/vnd.oasis.opendocument.text-web;application/oebps-package+xml;application/vnd.intu.qbo;application/vnd.openofficeorg.extension;application/vnd.yamaha.openscoreformat;audio/webm;video/webm;application/vnd.oasis.opendocument.char;application/vnd.oasis.opendocument.chart-template;application/vnd.oasis.opendocument.database;application/vnd.oasis.opendocument.formula;application/vnd.oasis.opendocument.formula-template;application/vnd.oasis.opendocument.grapics;application/vnd.oasis.opendocument.graphics-template;application/vnd.oasis.opendocument.image;application/vnd.oasis.opendocument.image-template;application/vnd.oasis.opendocument.presentation;application/vnd.oasis.opendocumen.presentation-template;application/vnd.oasis.opendocument.spreadsheet;application/vnd.oasis.opendocument.spreadsheet-template;application/vnd.oasis.opendocument.text;application/vnd.oasis.opendocument.text-master;application/vnd.asis.opendocument.text-template;image/ktx;application/vnd.sun.xml.calc;application/vnd.sun.xml.calc.template;application/vnd.sun.xml.draw;application/vnd.sun.xml.draw.template;application/vnd.sun.xml.impress;application/vnd.sun.xl.impress.template;application/vnd.sun.xml.math;application/vnd.sun.xml.writer;application/vnd.sun.xml.writer.global;application/vnd.sun.xml.writer.template;application/x-font-otf;application/vnd.yamaha.openscoreformat.osfpvg+xml;application/vnd.osgi.dp;application/vnd.palm;text/x-pascal;application/vnd.pawaafile;application/vnd.hp-pclxl;application/vnd.picsel;image/x-pcx;image/vnd.adobe.photoshop;application/pics-rules;image/x-pict;application/x-chat;aplication/pkcs10;application/x-pkcs12;application/pkcs7-mime;application/pkcs7-signature;application/x-pkcs7-certreqresp;application/x-pkcs7-certificates;application/pkcs8;application/vnd.pocketlearn;image/x-portable-anymap;image/-portable-bitmap;application/x-font-pcf;application/font-tdpfr;application/x-chess-pgn;image/x-portable-graymap;image/png;image/x-portable-pixmap;application/pskc+xml;application/vnd.ctc-posml;application/postscript;application/xfont-type1;application/vnd.powerbuilder6;application/pgp-encrypted;application/pgp-signature;application/vnd.previewsystems.box;application/vnd.pvi.ptid1;application/pls+xml;application/vnd.pg.format;application/vnd.pg.osasli;tex/prs.lines.tag;application/x-font-linux-psf;application/vnd.publishare-delta-tree;application/vnd.pmi.widget;application/vnd.quark.quarkxpress;application/vnd.epson.esf;application/vnd.epson.msf;application/vnd.epson.ssf;applicaton/vnd.epson.quickanime;application/vnd.intu.qfx;video/quicktime;application/x-rar-compressed;audio/x-pn-realaudio;audio/x-pn-realaudio-plugin;application/rsd+xml;application/vnd.rn-realmedia;application/vnd.realvnc.bed;applicatin/vnd.recordare.musicxml;application/vnd.recordare.musicxml+xml;application/relax-ng-compact-syntax;application/vnd.data-vision.rdz;application/rdf+xml;application/vnd.cloanto.rp9;application/vnd.jisp;application/rtf;text/richtex;application/vnd.route66.link66+xml;application/rss+xml;application/shf+xml;application/vnd.sailingtracker.track;image/svg+xml;application/vnd.sus-calendar;application/sru+xml;application/set-payment-initiation;application/set-reistration-initiation;application/vnd.sema;application/vnd.semd;application/vnd.semf;application/vnd.seemail;application/x-font-snf;application/scvp-vp-request;application/scvp-vp-response;application/scvp-cv-request;application/svp-cv-response;application/sdp;text/x-setext;video/x-sgi-movie;application/vnd.shana.informed.formdata;application/vnd.shana.informed.formtemplate;application/vnd.shana.informed.interchange;application/vnd.shana.informed.package;application/thraud+xml;application/x-shar;image/x-rgb;application/vnd.epson.salt;application/vnd.accpac.simply.aso;application/vnd.accpac.simply.imp;application/vnd.simtech-mindmapper;application/vnd.commonspace;application/vnd.ymaha.smaf-audio;application/vnd.smaf;application/vnd.yamaha.smaf-phrase;application/vnd.smart.teacher;application/vnd.svd;application/sparql-query;application/sparql-results+xml;application/srgs;application/srgs+xml;application/sml+xml;application/vnd.koan;text/sgml;application/vnd.stardivision.calc;application/vnd.stardivision.draw;application/vnd.stardivision.impress;application/vnd.stardivision.math;application/vnd.stardivision.writer;application/vnd.tardivision.writer-global;application/vnd.stepmania.stepchart;application/x-stuffit;application/x-stuffitx;application/vnd.solent.sdkm+xml;application/vnd.olpc-sugar;audio/basic;application/vnd.wqd;application/vnd.symbian.install;application/smil+xml;application/vnd.syncml+xml;application/vnd.syncml.dm+wbxml;application/vnd.syncml.dm+xml;application/x-sv4cpio;application/x-sv4crc;application/sbml+xml;text/tab-separated-values;image/tiff;application/vnd.to.intent-module-archive;application/x-tar;application/x-tcl;application/x-tex;application/x-tex-tfm;application/tei+xml;text/plain;application/vnd.spotfire.dxp;application/vnd.spotfire.sfs;application/timestamped-data;applicationvnd.trid.tpt;application/vnd.triscape.mxs;text/troff;application/vnd.trueapp;application/x-font-ttf;text/turtle;application/vnd.umajin;application/vnd.uoml+xml;application/vnd.unity;application/vnd.ufdl;text/uri-list;application/nd.uiq.theme;application/x-ustar;text/x-uuencode;text/x-vcalendar;text/x-vcard;application/x-cdlink;application/vnd.vsf;model/vrml;application/vnd.vcx;model/vnd.mts;model/vnd.vtu;application/vnd.visionary;video/vnd.vivo;applicatin/ccxml+xml,;application/voicexml+xml;application/x-wais-source;application/vnd.wap.wbxml;image/vnd.wap.wbmp;audio/x-wav;application/davmount+xml;application/x-font-woff;application/wspolicy+xml;image/webp;application/vnd.webturb;application/widget;application/winhlp;text/vnd.wap.wml;text/vnd.wap.wmlscript;application/vnd.wap.wmlscriptc;application/vnd.wordperfect;application/vnd.wt.stf;application/wsdl+xml;image/x-xbitmap;image/x-xpixmap;image/x-xwindowump;application/x-x509-ca-cert;application/x-xfig;application/xhtml+xml;application/xml;application/xcap-diff+xml;application/xenc+xml;application/patch-ops-error+xml;application/resource-lists+xml;application/rls-services+xml;aplication/resource-lists-diff+xml;application/xslt+xml;application/xop+xml;application/x-xpinstall;application/xspf+xml;application/vnd.mozilla.xul+xml;chemical/x-xyz;text/yaml;application/yang;application/yin+xml;application/vnd.ul;application/zip;application/vnd.handheld-entertainment+xml;application/vnd.zzazz.deck+xml");
					
					dc.setCapability(FirefoxDriver.PROFILE, profile);
					dc.setCapability(
							CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
							true);
					dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					driver = new FirefoxDriver(dc);
				} catch (Exception x) {
					x.printStackTrace();
					System.out
							.print("Encountered fatal error due to exception "
									+ x.getStackTrace());
					System.exit(1);
				}
			}
			break;
		//If the Browser is Chrome
		case "CHROME":
			System.out
					.println("---------------chrome driver initialized ---------- OS : "
							+ System.getProperty("os.name") + "----------");
			//OS - Mac
			if (System.getProperty("os.name").toUpperCase().contains("MAC")) {

				try {
					capabilities = DesiredCapabilities.chrome();
					System.setProperty("webdriver.chrome.driver",
							lplCoreConstents.MAC_CHROME_DRIVER_PATH);
					driver = new ChromeDriver(capabilities);
				} catch (Exception x) {
					x.printStackTrace();
					System.out
							.print("Encountered fatal error due to exception "
									+ x.getStackTrace());
					System.exit(1);
				}
			} else { // Treat it as windows
				try {

					// -----------------------------------------
					capabilities = DesiredCapabilities.chrome();
					System.setProperty("webdriver.chrome.driver",
							lplCoreConstents.WIN_CHROME_DRIVER_PATH);
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					((DesiredCapabilities) capabilities).setCapability(
							"chrome.binary", "");
					((DesiredCapabilities) capabilities).setCapability(
							"chrome.switches",
							Arrays.asList("--ignore-certificate-errors"));
					((DesiredCapabilities) capabilities).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				     Map<String, Object> prefs = new HashMap<String, Object>();
				     prefs.put("download.default_directory", lplCoreConstents.DefaultDownloadFolder);
				     options.setExperimentalOption("prefs", prefs);
					options.addArguments(Arrays.asList(
							"allow-running-insecure-content",
							"ignore-certificate-errors"));
					options.addArguments(Arrays.asList("test-type",
							"start-maximized", "no-default-browser-check"));
					options.addArguments("--disable-popup-blocking");
					options.addArguments("--disable-extensions");
					((DesiredCapabilities) capabilities).setCapability(
							ChromeOptions.CAPABILITY, options);
					driver = new ChromeDriver(capabilities);
				} catch (Exception x) {
					x.printStackTrace();
					System.out
							.print("Encountered fatal error due to exception "
									+ x.getStackTrace());
					System.exit(1);
				}
			}

			break;
		case "IE":
		case "INTERNETEXPLORER":
		case "IEXPLORE":
			//If the Browser is Internet Explorer
			System.out
					.println("---------------Internet Explorer driver initialized ---------- ");
			System.out.println("OS : " + System.getProperty("os.name"));
			try {
				// Deleting IE Cache
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
				//Deleting IE Cookies 
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 8");
				//Deleting IE Saved Passwords
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 16");
				//Deleting IE Saved Form data
				Runtime.getRuntime().exec(
						"RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 32");
				LPLCoreReporter
				.WriteReport(
						"Clearing Cache, Cookies, Passwords and Form data from IE",
						"Cache, Cookies, Passwords and Form data from IE should be cleared",
						"Deleted Complete Cache, Cookies, Passwords and Form data from IE",
						"Done", "");
				System.setProperty("webdriver.ie.driver", lplCoreConstents.WIN_IE_DRIVER32_PATH);
				
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();  
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				ieCapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
				ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				//This command will be updated later
				String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";

				//Setting Default Download Folder for IE
				String downloadFolderCmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Download Directory\" /T REG_SZ /D " + "\"" +lplCoreConstents.DefaultDownloadFolder+ "\"";
				String DefdownloadFolderCmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\" /F /V \"Default Download Directory\" /T REG_SZ /D " + "\"" +lplCoreConstents.DefaultDownloadFolder+ "\"";
				try {
				    Runtime.getRuntime().exec(cmd);
				    Runtime.getRuntime().exec(downloadFolderCmd);
				    Runtime.getRuntime().exec(DefdownloadFolderCmd); 
				} catch (Exception e) {
				    System.out.println("Error occured!");
				}
				//If product is CW & PROD turn off compatability Mode - No need of compatability mode for both Branchnet & clientworks
				if ((ocfg.getProductId()==intBranchNetProductID)){
					if((ocfg.getEnvId()==intProdVIPEnvID) &&(ocfg.getFirmId()==intLPLFirmID)){
						ieCapabilities.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, lplCoreConstents.UNITINMILLISEC);
					}
					
					//Disabled it for Updated iRule for both Branchnet and clientworks as per bala's request (12/01/2017)
					//turnOnCompModeIE();
					//System.out.println("Compatibility Mode enabled");
				}
				
				driver = new InternetExplorerDriver(ieCapabilities);
			} catch (Exception x) {
				x.printStackTrace();
				System.out.print("Encountered fatal error due to exception "
						+ x.getStackTrace());
				System.exit(1);
			}
			break;

		case "EDGE":
			//If the Browser is Microsoft Edge
			capabilities = DesiredCapabilities.edge();
			((DesiredCapabilities) capabilities).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			try {
				driver = new EdgeDriver(capabilities);
			} catch (Exception x) {
				x.printStackTrace();
				System.out.print("Encountered fatal error due to exception "
						+ x.getStackTrace());
				System.exit(1);
			}
			break;
		case "SAFARI":
			//If the Browser is Safari
			capabilities = DesiredCapabilities.safari();
			((DesiredCapabilities) capabilities).setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			try {
				driver = new SafariDriver(capabilities);
			} catch (Exception x) {
				x.printStackTrace();
				System.out.print("Encountered fatal error due to exception "
						+ x.getStackTrace());
				System.exit(1);
			}
			
		case "WEBSERVICES":
		case "WEBSERVICE":
		case "PHANTOMJS":
			
			//If the Browser is Internet Explorer
			System.out
					.println("---------------PhantomJs driver initialized ---------- ");
			System.out.println("OS : " + System.getProperty("os.name"));
			
			try{			
			
				DesiredCapabilities capabilitiesPhantom = new DesiredCapabilities();
				capabilitiesPhantom.setJavascriptEnabled(true);
				//caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/Users/graju/workspace/phantomjs-2.1.1-windows/bin/phantomjs.exe");   //WIN_PHANTOMJS_DRIVER32_PATH
				capabilitiesPhantom.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, lplCoreConstents.WIN_PHANTOMJS_DRIVER32_PATH);   //
				driver = new PhantomJSDriver(capabilitiesPhantom);
			} catch (Exception x) {
				x.printStackTrace();
				System.out.print("Encountered fatal error due to exception "
						+ x.getStackTrace());
				System.exit(1);
			}
		}

		/*
		 * ************************************* Retrieving LogIn & Test Data From Farm ***********************************************
		 */

		if (lplCoreConstents.strEncryptionFlag.equals("YES")){
		loginCredentials = LPLCoreDBConnect.getLoginCredentialFromDB(ocfg.getScriptId(), ocfg.getFirmId(), ocfg.getProductId(),ocfg.getEnvId(),lplCoreConstents.strCryptoKey, lplCoreConstents.strEncryptionFlag);
		}
		else
		{
		loginCredentials = LPLCoreDBConnect.getLoginCredentialFromDB(ocfg.getScriptId(), ocfg.getFirmId(), ocfg.getProductId(),ocfg.getEnvId(),"",lplCoreConstents.strEncryptionFlag);
		}
		testData = LPLCoreDBConnect.getTestDataFromDB(ocfg.getScriptId(), ocfg.getEnvId());

		/*
		 * ************************************* Create date format and date object for reporting purpose **************************************
		 */

		dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		date = new Date();
		
		/*
		 * **************************************** Create NgWebDriver object to
		 * handle Angular objects ***************************************
		 */
		if (ocfg.getProductId()==intBranchNetProductID){
			System.out.println("Branchnet Perspective starting");
		}else if ((ocfg.getProductId()==intClientWorksProductID) && (ocfg.getFirmId()==intLPLFirmID)) {
			System.out.println("Clientworks LPL Perspective starting");

			ngDriver = new NgWebDriver((JavascriptExecutor) driver);
			System.out.println("ngDriver initialized successfully....");
		}else if ((ocfg.getProductId()==intClientWorksProductID) && (ocfg.getFirmId()!=intLPLFirmID)) {
			System.out.println("Clientworks Perspective starting");
		}
		
		/*
		 * ********************************************************* Launch URL ****************************************************************
		 */
		/** Clearing Cookies */
		driver.manage().deleteAllCookies();
		LPLCoreReporter.WriteReport("Clearing Cache and Cookies", "Cookies and Cache should be cleared successfully","Cleared", "Done", "");

		/*DynatraceFlag Check */
		if (ocfg.getDynatraceFlag().toUpperCase().contains("YES") || ocfg.getDynatraceFlag().toUpperCase().contains("Y")) { 
			
			/*
			 RESTEndpoint endPoint = new RESTEndpoint("DTSeleniumSvc","i.love.dt2","TXDTMAINDEV11.SDDEV.LPL.COM:2021");
			String sessionName = endPoint.startRecording("ClientWorks", "QAAutomation-Session-CW-DEVINT-IE-1", "Starting Test Session", "all", true, false);
			*/
			
					
			/** Launch the Application URL from Dynatrace and adding timer name with following format (Starting QAAutomation-CW-DEVINT-IE)*/
			//DynaTraceWebDriver.forWebDriver(driver).get(ocfg.getURL());
			DynaTraceWebDriverHelper.forDriver(driver).open(ocfg.getURL(), "Starting_QAAutomation_Timer -"+ ocfg.getApplication()+"-"+ocfg.getEnvironment()+"-"+ocfg.getBrowserType());
		}
		else {
			/** Launch the Application URL */
			try{
				/*To handle windows authentication popup for service works in chrome browser 
					where we will get popup for multiple times. So resetting the URL with UN & PWD and calling the exe
				*/
				if(ocfg.getProductId()==intServiceworksProductID && ocfg.getBrowserType().toUpperCase().contains("CHROME")){
						if(ocfg.getURL().contains("http://")){
							ocfg.setURL(ocfg.getURL().replace("http://", "https://"+loginCredentials.get("Username")+":"+loginCredentials.get("Password")+"@"));
						}else{
							ocfg.setURL(ocfg.getURL().replace("https://","https://"+loginCredentials.get("Username")+":"+loginCredentials.get("Password")+"@"));
						}
						driver.get(ocfg.getURL());
						windowsSecurityLoginForChrome(loginCredentials.get("Username"),loginCredentials.get("Password"));
				
				//To handle windows authentication popup for BackOffice in Chrome browser we have to run the exe first and then enter the URL.
				}else if(ocfg.getProductId()==intBackOfficeProductID && ocfg.getBrowserType().toUpperCase().contains("CHROME")){
					windowsSecurityLoginForChrome(loginCredentials.get("Username"),loginCredentials.get("Password"));
					driver.get(ocfg.getURL());
						
				}else{
					//Enter the URL
					driver.get(ocfg.getURL());
				}
			}catch(Exception x){
				//wait for page to load
				LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
				if (driver.getTitle().contains("Insecure Connection")){
					try {
						//To click on advanced button
						LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id("advancedButton")).click();
						LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
						//To click on Exception button
						LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id("exceptionDialogButton")).click();
						firefoxExceptionHandler();
					} catch (Exception e) {
						LPLCoreReporter.WriteReport("URL Launch", "URL should be launched withour Error or Exception","Webdriver exception occured. Error: " + e.getMessage(), LPLCoreConstents.FAILED, "");
					}
				}
			}
		}
		
		WindowsSecurityLogin(loginCredentials.get("Username"),loginCredentials.get("Password"));
		if(ocfg.getApplication().equalsIgnoreCase("CARS Reports")){
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			WindowsSecurityLogin(loginCredentials.get("Username"),loginCredentials.get("Password"));
		}
		/** NgDriver Call if the App is not BranchNet (BranchNet does not have AngularJS elements) */
		if ((ocfg.getProductId()==intBranchNetProductID) &&
				(ocfg.getEnvironment().toUpperCase().contains("QA"))){
			
			driver.manage().timeouts().implicitlyWait(lplCoreConstents.UNIT, TimeUnit.SECONDS);
		} else if ((ocfg.getProductId()==intClientWorksProductID) && (ocfg.getFirmId()==intLPLFirmID)) {
			ngDriver.waitForAngularRequestsToFinish();
		}else if (((ocfg.getProductId()==intClientWorksProductID) && (ocfg.getFirmId()!=intLPLFirmID)) &&
		(ocfg.getEnvironment().toUpperCase().contains("QA"))) {
			driver.manage().timeouts().implicitlyWait(lplCoreConstents.UNIT, TimeUnit.SECONDS);
		}
		
		/** 
		 * 	Handle Login Certificates in PRODVIP Environment for BranchNet Application 																						
		 */
		selectCertificate();
		
		/** Maximize the Browser Window */
		LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
		if(!ocfg.getBrowserType().toUpperCase().contains("CHROME") && !ocfg.getBrowserType().toUpperCase().contains("FIREFOX")){
			driver.manage().window().maximize();
		}

		/*
		 * ****************************************** Handle SSL Certificate Issue For IE Browser **********************************************
		 */
		if((ocfg.getBrowserType().toUpperCase().trim().equals("IEXPLORE")) || (ocfg.getBrowserType().toUpperCase().trim().equals("IE"))){
			if(driver.findElements(By.id("overridelink")).size()>0)
				driver.findElement(By.id("overridelink")).click();
		}
		
		/*
		 * ****************************************** Write a consolidated
		 * summary report.
		 * ******************************************************
		 */
		LPLCoreReporter.writeConsolidatedSummary();
		
		/*
		 * ************************************* Return the driver instance to
		 * be used in script ***********************************************
		 */
		return driver;
	}

	/**
	 * To Turn on Compatibility view if the Browser is IE
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param None
	 * @return None
	 */
	public static void turnOnCompModeIE() {
		try {
			String[] strCmpViewCommand = LPLCoreConstents.getInstance().strCompViewCommand.split(",");
			
			//Create JAVA Runtime class to execute the windows command to execute the AutoIT exe file to select the required Certificate
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(strCmpViewCommand);
				try {
					int value = process.waitFor();
					if(value!=0)
						LPLCoreReporter.WriteReport("Compatibility View Enabling Process", "Compatibility View Enabling Process should be successful","Compatibility View Enabling Process terminated abnormally.", LPLCoreConstents.FAILED, "");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			LPLCoreReporter.WriteReport("Compatibility View for IE", "Compatibility View Enabling Process should be successful","Compatibility View Enabling Process successful", LPLCoreConstents.PASSED, "");
			
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe *32");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * public void CleanUpAndEndTest(ExtentReports extentReports,ExtentTest
	 * extentTest){*************** Clean Up *************************
	 * 
	 * End of Report Creation extentReports.endTest(extentTest);
	 * extentReports.flush(); extentReports.close();
	 * 
	 * if (ocfg.getExecutionLocation().toUpperCase().contains("LOCAL")){
	 * driver.get(strReportPath); }
	 * 
	 * ocfg = null; dateFormat=null; date=null; loginCredentials = null;
	 * testData=null; extentReports=null; extentTest=null; ngDriver=null; }
	 */
	
	/**
	 * To Close the Dynatrace or Webservice or Browser Session
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param None
	 * @return None
	 */
	public static void closeSession(){
		/*DynatraceFlag Check */
		if (ocfg.getDynatraceFlag().toUpperCase().contains("YES") || ocfg.getApplication().toUpperCase().contains("Y")) {
//			DynaTraceWebDriverHelper.forDriver(driver).removeTimerName();
//			DynaTraceWebDriverHelper.forDriver(driver).clearTimerName();
		}else {
			/** Launch the Application URL */
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
		}
	}
	
	/**
	 * Run test by searching for the class automatically
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param None
	 * @return (Object) returns the loaded class file
	 */
	public Object runTest(String strTestNameWithPackagePath) {
		ClassLoader c = new ClassLoader() {
		};
		try {
			return c.loadClass(strTestNameWithPackagePath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method to Close all browser processes running if the executions happens in Farm
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param None
	 * @return None
	 */
	public static void closeAllBrowserProcesses(LPLConfig cfg) {
		try {
			if (cfg.getExecutionLocation().equalsIgnoreCase("Farm")) {
				Runtime.getRuntime().exec(
						"taskkill /F /IM IEDriverServer.exe *32");
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				Runtime.getRuntime().exec(
						"taskkill /F /IM chromedriver.exe *32");
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe *32");
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe *32");
				Runtime.getRuntime().exec("taskkill /F /IM Firefox.exe");
				Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
				Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
				Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM phantomjs.exe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This function is used to handle login certificates in PRODVIP environment for BranchNet Application  
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 10-18-2016
	 * @param N/A
	 * @return N/A
	 */
	public static void selectCertificate(){
		try{
			/** 
			 * 	Handle Login Certificates in PRODVIP Environment for BranchNet Application 																						
			 */
			if((ocfg.getEnvironment().toUpperCase().contains("PROD") || ocfg.getEnvironment().toUpperCase().contains("PRD")) && (ocfg.getProductId()==intBranchNetProductID) &&(ocfg.getFirmId()==intLPLFirmID)){
				//String to hold certificate name
				String strCertName = null;
				
				//Select different certificate names as per the UserName
				switch(loginCredentials.get("Username").toLowerCase().trim()){
					case "darwinv.lpl2":
						strCertName = "lpl2";
						break;
					case "darwinv.lpladv3a":
						strCertName = "lpladv3a";
						break;
					case "darwin.villaruz":
						strCertName = "emp";
						break;
					default:
						LPLCoreReporter.WriteReport("Username verification for certificate selection.", "Username verification should be successful","Username:["+loginCredentials.get("Username")+"] not matched for any Certificate.", LPLCoreConstents.FAILED, "");
						break;
				}
				
				/**
				 * Create the Certificate selection windows command to execute the AutoIT exe file.
				 * Sample command: String[] command = {"cmd.exe", "/C", "Start", "C:\\Automation\\SelectCertificate.exe", "lpl2"};
				 */
				String strCertCommand = LPLCoreConstents.getInstance().strCertCommand+ "," + strCertName;
				String[] strCertSelectionCommand = strCertCommand.split(",");
				
				//Create JAVA Runtime class to execute the windows command to execute the AutoIT exe file to select the required Certificate
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec(strCertSelectionCommand);
					try {
						int value = process.waitFor();
						if(value!=0)
							LPLCoreReporter.WriteReport("Cert selection Command Execution Process", "Cert selection Command Execution Process should be successful","Cert selection Command Execution Process terminated abnormally.", LPLCoreConstents.FAILED, "");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				LPLCoreReporter.WriteReport("Certificate Selection", "Certificate Selection should be successful","Certificate selected successfully for User:[."+loginCredentials.get("Username")+"]", LPLCoreConstents.PASSED, "");
			}
		}catch(Exception ex){
			System.out.println("Certificate Not found!!!");
		}
	}
	
	/**
	 * This function is used to select login certificates in PRODVIP environment after BN menu navigation  
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 10-19-2016
	 * @param N/A
	 * @return N/A
	 */
	public static void selectCertAfterMenuNavigation(){
		try {
			try{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				//Added the below code to select the certificate pop-up displayed after the menu navigation  
				LPLCoreDriver.selectCertificate();
			}catch(Exception ex){
				LPLCoreDriver.selectCertificate();
			}finally{
				//driver.switchTo().window(parentWindowHandle);
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			System.out.println("Certificate Not found");
		}
	}
	
	/**
	 * Method to login with Windows credentials
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-14-2017
	 * @param username
	 *            - Username, password - Password
	 * @return boolean
	 */
	public static void WindowsSecurityLogin(String strUserName, String strPassword) {
        try {
               if(ocfg.getProductId()==intBackOfficeProductID){
            	   LPLCoreSync.waitForAlert(driver, LPLCoreConstents.getInstance().BASE);
               }
               //Switching to alert and logging in using credentials
               Alert alert = driver.switchTo().alert();
               
               alert.authenticateUsing(new UserAndPassword(strUserName, strPassword));
        } catch (Exception e) {
              
               String strCertCommand = LPLCoreConstents.getInstance().strWinAuthCommand+","+strUserName + "," +strPassword;
               String[] strCertSelectionCommand = strCertCommand.split(",");
               
               Runtime runtime = Runtime.getRuntime();
               try {
                     Process process = runtime.exec(strCertSelectionCommand);
                     try {
                            int value = process.waitFor();
                            if(value!=0)
                                   LPLCoreReporter.WriteReport("Handle the window authentication", "Window authentication should be handled","Failed to Handle the window authentication", LPLCoreConstents.FAILED, "");
                     } catch (InterruptedException ex) {
                            ex.printStackTrace();
                            }
                     
                     LPLCoreReporter.WriteReport("Handle the window authentication", "Window authentication should be handled","Successfully Handled the window authentication", LPLCoreConstents.PASSED, "");
               } catch (IOException e1) {
                     e1.printStackTrace();
                     }
        }
}

	
	/**
	 * Method To handle firefox webdriver exception
	 * @author Jyothi Jyothi
	 * @since 03-17-2017
	 * @param None
	 * @return None
	 */
	public static void firefoxExceptionHandler() {
		try {
			String[] strFirefoxExceptionHandlerCommand = LPLCoreConstents.getInstance().strFirefoxExceptionHandlerCommand.split(",");
			//Create JAVA Runtime class to execute the windows command to execute the AutoIT exe file to handle firefox webdriver exception
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(strFirefoxExceptionHandlerCommand);
				try {
					int value = process.waitFor();
					if(value!=0)
						LPLCoreReporter.WriteReport("Handle firefox exception", "Handling of firefox exception should be successful","Firefox exception handled unsuccessful", LPLCoreConstents.FAILED, "");
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			} catch (IOException e) {
				e.printStackTrace();
				}
			//Since we use EXE call, we are using static wait here
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			LPLCoreReporter.WriteReport("Handle firefox exception", "Handling of firefox exception should be successful","Firefox exception handled successful", LPLCoreConstents.PASSED, "");	
		} catch (Exception e) {
			LPLCoreReporter.WriteReport("Handle firefox exception", "Handling of firefox exception should be successful","Firefox exception handling failed. Error: " + e.getMessage(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * Method to login with Windows credentials for chrome browser
	 * 
	 * @author Sunitha appaiah
	 * @since 03-27-2018
	 * @param username
	 *            - Username, password - Password
	 * @return boolean
	 */
	public static void windowsSecurityLoginForChrome(String strUserName, String strPassword) {
        try {
             String strCertCommand = LPLCoreConstents.getInstance().strChromeWinAuthCommand+","+strUserName + "," +strPassword;
               String[] strCertSelectionCommand = strCertCommand.split(",");
               
               Runtime runtime = Runtime.getRuntime();
               try {
                     Process process = runtime.exec(strCertSelectionCommand);
                     try {
                            int value = process.waitFor();
                            if(value!=0)
                                   LPLCoreReporter.WriteReport("Handle the window authentication for chrome", "Window authentication for chrome should be handled","Failed to Handle the window authentication for chrome", LPLCoreConstents.FAILED, "");
                     } catch (InterruptedException ex) {
                            ex.printStackTrace();
                            }
                     
                     LPLCoreReporter.WriteReport("Handle the window authentication for chrome", "Window authentication for chrome should be handled","Successfully Handled the window authentication for chrome", LPLCoreConstents.PASSED, "");
               process.destroy();
               } catch (IOException e1) {
                     e1.printStackTrace();
                     }
        } catch (Exception e) {
        	e.printStackTrace();
        }
}
}