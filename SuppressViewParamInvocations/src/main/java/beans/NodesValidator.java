package beans;

import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.primefaces.model.mindmap.MindmapNode;

/**
 *
 * @author Anghel Leonard
 */
@FacesValidator("nodesValidator")
public class NodesValidator implements Validator {

    private static final Logger LOG = Logger.getLogger(NodesValidator.class.getName());

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        LOG.info("NodesValidator#validate() ...");

        if (((MindmapNode)value).getChildren().isEmpty()) {         
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "You cannot have a mindmap only with a root !", null));
        }
    }

}
