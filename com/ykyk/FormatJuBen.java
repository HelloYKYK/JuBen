package com.ykyk;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by toy on 2016/9/16.
 */
public class FormatJuBen {

    public static void main(String[] args) {

//        formatJuBen("juben/fromTxt.txt", "juben/formatedTxt.html");
//        addToIndexHtml();
//        modifyHtml();
        formatJuBen("juben/formatfiles/","juben/formatedfiles");
    }

    /**
     * 改所有的html格式
     */
    private static void modifyHtml() {
//        StringBuffer sb = new StringBuffer();
        File dictionery = new File("juben/html/test/春梦随云散");
        File[] files = dictionery.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()&&files[i].getName().endsWith("html")) {
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader reader = null;
                    reader = new BufferedReader(new FileReader(files[i]));
                    StringBuilder result = new StringBuilder();
                    String theLine = null;
                    while ((theLine = reader.readLine()) != null) {
                        result.append(theLine + "\n");
                    }
                    sb = result;
                } catch (Exception e) {
                    e.printStackTrace();
                }


                System.out.println("index" + sb.indexOf("<head>"));
                sb.replace(sb.indexOf("<head>") + 6, sb.indexOf("</title>"),
                        " <meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1\" >\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\">\n" +
                                "    <style type=\"text/css\">\n" +
                                "  body{background:#D1EEEE} \n" +
                                "  div{\n" +
                                "  word-wrap: break-word;\n" +
                                "  word-break: normal;\n" +
                                "  white-space:normal;\n" +
                                "  margin-bottom: 20px;\n" +
                                "  }\n" +
                                "\n" +
                                "</style>\n" +
                                "    <script>\n" +
                                "(function (doc, win) {\n" +
                                "        var docEl = doc.documentElement,\n" +
                                "            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',\n" +
                                "            recalc = function () {\n" +
                                "                var clientWidth = docEl.clientWidth;\n" +
                                "                if (!clientWidth) return;\n" +
                                "                if(clientWidth>=640){\n" +
                                "                    docEl.style.fontSize = '50px';\n" +
                                "                }else{\n" +
                                "                    docEl.style.fontSize = 24 * (clientWidth / 640) + 'px';\n" +
                                "                }\n" +
                                "            };\n" +
                                "\n" +
                                "        if (!doc.addEventListener) return;\n" +
                                "        win.addEventListener(resizeEvt, recalc, false);\n" +
                                "        doc.addEventListener('DOMContentLoaded', recalc, false);\n" +
                                "\n" +
                                "    })(document, window);\n" +
                                "\n" +
                                " window.onload=function(){\n" +
                                "      var divs=document.getElementsByTagName(\"div\");\n" +
                                "      //人物所在的行(div)\n" +
                                "      var index =0;\n" +
                                "      for (var l = 0; l < 10; l++) {\n" +
                                "        var str = divs[l].innerHTML;\n" +
                                "        if (str.indexOf(\"人物\")>=0) {index=l};\n" +
                                "      };\n" +
                                "      console.log(index);\n" +
                                "\n" +
                                "      var pepoleline = divs[index].innerHTML;\n" +
                                "      // 人物:旁白(大夫)凤姐，平儿，贾琏。\n" +
                                "      var pepole = pepoleline.substr(3,pepoleline.length);\n" +
                                "      //旁白 大夫 凤姐 平儿 贾琏\n" +
                                "      var pepoles = pepole.split(\"，\");\n" +
                                "      \n" +
                                "      //颜色值\n" +
                                "      var colors = new Array();\n" +
                                "      colors[0]=\"#77ACA8\";\n" +
                                "      colors[1]=\"#53c280\";\n" +
                                "      colors[2]=\"#CD96CD\";\n" +
                                "      colors[3]=\"#BCEE68\";\n" +
                                "      colors[4]=\"#6CA6CD\";\n" +
                                "      var pepolenames = new Array();\n" +
                                "\n" +
                                "      for (var j = 0; j < pepoles.length; j++) {\n" +
                                "          pepolenames[j]=pepoles[j].substr(0,2);\n" +
                                "          console.log(pepolenames[j]);\n" +
                                "        };\n" +
                                "\n" +
                                "      for(var i=0;i<divs.length;i++){\n" +
                                "        var str  = divs[i].innerHTML;\n" +
                                "        for (var k = 0; k < pepolenames.length; k++) {\n" +
                                "          if (str.substr(0,2)==pepolenames[k]) {divs[i].style.backgroundColor = colors[k%5];};\n" +
                                "        };         \n" +
                                "      }\n" +
                                "   }"+"</script>\n" +
                                "\n" +
                                "\t\t\t  <title>"+files[i].getName());
                System.out.println(files[i].getName());
                writeStringBuffer(files[i], sb);
            }
        }
    }

    private static void addToIndexHtml() {
        StringBuffer sb = new StringBuffer();
        File dictionery = new File("juben/html/飞花逐水流/");
        File[] files = dictionery.listFiles();
        for (int i = 1; i < files.length; i++) {
            if (files[i].isFile()) {
                String name = files[i].getName();
                sb.append("  <tr>\n" +
                        "    <td>\n" +
                        "      <h1> <a href=\"");
                sb.append("juben/html/飞花逐水流/" + name);//链接

                sb.append("\">");

                sb.append(name.replace(".html", ""));//文本,标题

                sb.append("</a></h1>\n" +
                        "    </td>\n" +
                        "  </tr>");
            }
        }
        //写
        writeStringBuffer(new File("juben/html/allIndex.txt"), sb);
    }

    //格式化剧本为html并保存到指定位置
    private static void formatJuBen(String fromFilePath, String formatedFilePath) {
        File dictionery = new File(fromFilePath);
        File[] files = dictionery.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
                StringBuffer stringBuffer = getStringBuffer(files[i]);
                File htmlFile = new File(formatedFilePath, i + "_" + files[i].getName().replace(".txt", "") + ".html");
                writeStringBuffer(htmlFile, stringBuffer);
            }
        }


//        File fromFile = new File(fromFilePath);
//        File file = new File(formatedFilePath);


//        //读
//        StringBuffer sb = getStringBuffer(fromFile);
//
//
////        写
//        writeStringBuffer(file, sb);
    }

    //读取指定剧本的文字并格式化为html,读取到stringbuild里
    private static StringBuffer getStringBuffer(File fromFile) {
        BufferedReader bufferedReader = null;
        StringBuffer sb = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile)));

            //  bufferedReader = new BufferedReader(new FileReader(fromFile));
            String lineString = null;
            sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"utf-8\" name=\"viewport\" content=\"width=device-width, initial-scale=1\" >\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\">\n" +
                    "    <style type=\"text/css\">\n" +
                    "  body{background:#D1EEEE} \n" +
                    "  div{\n" +
                    "  word-wrap: break-word;\n" +
                    "  word-break: normal;\n" +
                    "  white-space:normal;\n" +
                    "  margin-bottom: 20px;\n" +
                    "  }\n" +
                    "\n" +
                    "</style>\n" +
                    "    <script>\n" +
                    "(function (doc, win) {\n" +
                    "        var docEl = doc.documentElement,\n" +
                    "            resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',\n" +
                    "            recalc = function () {\n" +
                    "                var clientWidth = docEl.clientWidth;\n" +
                    "                if (!clientWidth) return;\n" +
                    "                if(clientWidth>=640){\n" +
                    "                    docEl.style.fontSize = '50px';\n" +
                    "                }else{\n" +
                    "                    docEl.style.fontSize = 24 * (clientWidth / 640) + 'px';\n" +
                    "                }\n" +
                    "            };\n" +
                    "\n" +
                    "        if (!doc.addEventListener) return;\n" +
                    "        win.addEventListener(resizeEvt, recalc, false);\n" +
                    "        doc.addEventListener('DOMContentLoaded', recalc, false);\n" +
                    "\n" +
                    "    })(document, window);\n" +
                    "\n" +
                    " window.onload=function(){\n" +
                    "      var divs=document.getElementsByTagName(\"div\");\n" +
                    "      //人物所在的行(div)\n" +
                    "      var index =0;\n" +
                    "      for (var l = 0; l < 5; l++) {\n" +
                    "        var str = divs[l].innerHTML;\n" +
                    "        if (str.indexOf(\"人物\")>=0) {index=l};\n" +
                    "      };\n" +
                    "      console.log(index);\n" +
                    "      var pepoleline = divs[1].innerHTML;\n" +
                    "      // 人物:旁白(大夫)凤姐，平儿，贾琏。\n" +
                    "      var pepole = pepoleline.substr(3,pepoleline.length);\n" +
                    "      //旁白 大夫 凤姐 平儿 贾琏\n" +
                    "      var pepoles = pepole.split(\"，\");\n" +
                    "      \n" +
                    "      //颜色值\n" +
                    "      var colors = new Array();\n" +
                    "      colors[0]=\"#77ACA8\";\n" +
                    "      colors[1]=\"#53c280\";\n" +
                    "      colors[2]=\"#CD96CD\";\n" +
                    "      colors[3]=\"#BCEE68\";\n" +
                    "      colors[4]=\"#6CA6CD\";\n" +
                    "      var pepolenames = new Array();\n" +
                    "\n" +
                    "      for (var j = 0; j < pepoles.length; j++) {\n" +
                    "          pepolenames[j]=pepoles[j].substr(0,2);\n" +
                    "          console.log(pepolenames[j]);\n" +
                    "        };\n" +
                    "\n" +
                    "      for(var i=0;i<divs.length;i++){\n" +
                    "        var str  = divs[i].innerHTML;\n" +
                    "        for (var k = 0; k < pepolenames.length; k++) {\n" +
                    "          if (str.substr(0,2)==pepolenames[k]&&str.substr(0,2)!=\"旁白\") {divs[i].style.backgroundColor = colors[k%5];};\n" +
                    "        };         \n" +
                    "      }\n" +
                    "   }\n" +
                    "\n" +
                    "</script>" +
                    "\n" +
                    "\t\t\t  <title>" + bufferedReader.readLine() + "</title>\n" +
                    "\n" +
                    "\n" +
                    "\t\t</head>\n" +
                    "  <body oncontextmenu=self.event.returnValue=false ontouchstart = \"return false;\" onselectstart=\"return false\">");
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fromFile)));

            while ((lineString = bufferedReader.readLine()) != null) {
                sb.append("<div>");
                sb.append(lineString);
                sb.append("</div>");
            }
            sb.append("\n" +
                    " </body>\n" +
                    "  </html>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("readOk");

            //关闭BufferedReader
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb;
    }

    private static void writeStringBuffer(File file, StringBuffer sb) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("写入完毕");
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    } private static void writeStringBuffer(File file, StringBuilder sb) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("写入完毕");
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    private static void writeStringBufferHtml(File file, StringBuffer sb) {
        BufferedWriter bufferedWriter = null;
        try {
            //  bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"GBK"));

            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(sb.toString());
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ok!");
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}
