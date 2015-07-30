package fr.imie.bankocash.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import fr.imie.bankocash.Virement;
import fr.imie.bankocash.services.BankService;

/**
 * Message-Driven Bean implementation class for: VirementMBD
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(propertyName = "destination",
		                                               propertyValue = "java:/jms/queue/bankocash/virement"),
		                     @ActivationConfigProperty(propertyName = "destinationType",
		                                               propertyValue = "javax.jms.Queue"),
		                     @ActivationConfigProperty(propertyName="ConnectionFactoryName",
		                                               propertyValue="java:/ConnectionFactory")
		},
		mappedName = "BankoCashVirement")
public class VirementMBD implements MessageListener {

    @EJB
    private BankService serv;
    /**
     * Default constructor. 
     */
    public VirementMBD() {
        super();
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    @Override
    public void onMessage(Message message) {
        System.out.println("receive virement jms");
        try {
            Virement virement = message.getBody(Virement.class);
            serv.debiteCompte(virement.getFrom(), virement.getMontant());
            serv.crediteCompte(virement.getTo(), virement.getMontant());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
        }
        
    }

}
