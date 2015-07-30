package fr.imie.bankocash.jms;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

import fr.imie.bankocash.Virement;
@RequestScoped
public class VirementProducer {
    @Resource(mappedName = "java:/jms/queue/bankocash/virement")
    private Queue fileVirement;
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;
    public VirementProducer() {
        super();
    }
    
    public void sendMessage(Virement virement) {
        ObjectMessage objMsg = context.createObjectMessage();
        try {
            objMsg.setObject(virement);
            context.createProducer().send(fileVirement, objMsg);
        } catch (JMSException e) {
            // TODO Catch exception
        }
    }
}
