package br.com.lorde.supremo.jms.consumers;

import br.com.lorde.supremo.jms.ConsumerListner;
import br.com.lorde.supremo.jms.InitConnection;

import javax.jms.MessageConsumer;
import javax.jms.Topic;

public class TesteConsumidorTopicoProducao {

    public static void main(String[] args) throws Exception{
        InitConnection initConnection = new InitConnection("loja","producao");

        MessageConsumer consumer = initConnection.getSession().createDurableSubscriber(
            (Topic) initConnection.getDestination(), "signature_producao"
        );

        ConsumerListner consumerListner = new ConsumerListner();
        consumerListner.getConsumerListnerMsgText(consumer);

        initConnection.closeConnection();
    }
}
