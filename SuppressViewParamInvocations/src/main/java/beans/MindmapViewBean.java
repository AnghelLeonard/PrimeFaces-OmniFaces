package beans;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.mindmap.MindmapNode;

/**
 *
 * @author Anghel Leonard
 */
@Named
@ViewScoped
public class MindmapViewBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(MindmapViewBean.class.getName());

    private MindmapNode root;

    public MindmapViewBean() {
        LOG.info("MindmapViewBean#constructor ...");
    }

    public MindmapNode getRoot() {
        return root;
    }

    public void setRoot(MindmapNode root) {
        LOG.info("MindmapViewBean#setter ...");
        this.root = root;
    }

    public String resetMindMap() {
        LOG.info("MindmapViewBean#resetMindMap() ...");
        return "index?faces-redirect=true&includeViewParams=true";
    }

    public void onNodeSelect(SelectEvent event) {
        LOG.info("MindmapViewBean#onNodeSelect() ...");
    }
}
