import java.util.List;
import java.util.Map;

/**
 * @Author taomofan
 * @Date 2021/1/26 2:44 下午
 * @Version 1.0
 */
public class BuildHtml {
    public String buildHTML(List<Map<String, Object>> stringMap) {
        String htmlTitle = "<caption>这里是标题</caption>";
        String htmlTr = "";
        for(Map<String, Object> mapInfo:stringMap){
            String htmlTd = "<tr>" +
                    "<td align=\"center\">" + mapInfo.get("name").toString() + "</td>" +
                    "<td align=\"center\">" + mapInfo.get("code").toString() + "</td>" +
                    "<td align=\"center\">" + mapInfo.get("time").toString() + "</td>" +
                    "</tr>";
            htmlTr = htmlTr + htmlTd;
        }
        String htmlTable = "<table width=\"80%\" border=\"1\" align=\"center\">" + htmlTitle + htmlTr + "</table>";
        return htmlTable;
    }
}

