package beans;

import java.util.List;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.mindmap.DefaultMindmapNode;
import org.primefaces.model.mindmap.MindmapNode;

/**
 *
 * @author Anghel Leonard
 */
@FacesConverter("nodesConverter")
public class NodesConverter implements Converter {

    private static final Logger LOG = Logger.getLogger(NodesConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        LOG.info("NodesConverter#getAsObject() ...");

        if ((value != null) && (!value.isEmpty())) {

            String[] nodes = value.split("\\|");

            // create mindmap root                     
            MindmapNode root = new DefaultMindmapNode(nodes[0], nodes[0], "FFCC00", false);

            // add children to root
            if (nodes.length > 1) {
                for (int i = 1; i < nodes.length; i++) {
                    root.addNode(new DefaultMindmapNode(nodes[i], nodes[i], "6e9ebf", true));
                }
            }
            return root;
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        LOG.info("NodesConverter#getAsString() ...");
        if (value != null) {
            String queryString = ((DefaultMindmapNode) value).getLabel() + "|";
            List<MindmapNode> nodes = ((DefaultMindmapNode) value).getChildren();
            for (MindmapNode node : nodes) {
                queryString = queryString + node.getLabel() + "|";
            }
            return queryString;
        }
        return "";
    }

}
