/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.transport.jms;

import javax.jms.TextMessage;
import javax.mail.internet.ContentType;

import org.apache.synapse.transport.base.BaseConstants;
import org.apache.synapse.transport.testkit.client.AsyncTestClient;
import org.apache.synapse.transport.testkit.client.ClientOptions;
import org.apache.synapse.transport.testkit.name.Name;

@Name("TextMessage")
public class JMSTextMessageClient extends JMSClient implements AsyncTestClient<String> {
    public void sendMessage(ClientOptions options, ContentType contentType, String message) throws Exception {
        TextMessage jmsMessage = session.createTextMessage();
        if (contentTypeMode == ContentTypeMode.TRANSPORT) {
            jmsMessage.setStringProperty(BaseConstants.CONTENT_TYPE, contentType.toString());
        }
        jmsMessage.setText(message);
        producer.send(jmsMessage);
    }
}