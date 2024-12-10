# Real-Time Chat Application

**Interactive real-time messaging with modern web technologies.**

---

## 📋 Prerequisites
- Java Development Kit (JDK) 8 or higher  
- Maven installed for dependency management  
- MySQL for database integration 


---

## ✨ Features
1. **Real-Time Messaging**  
   Instantly send and receive messages using WebSocket technology.  

2. **Multiple User Support**  
   Seamlessly handle multiple users in a single chat environment.  

3. **Dynamic User Interface**  
   Responsive and clean design powered by Tailwind CSS for an intuitive experience.  

4. **Database Integration**  
   Option to store chat history in MySQL for persistence and retrieval.  

5. **Scalable Architecture**  
   Built with Spring Boot to handle growing user demands efficiently.  

6. **Browser Compatibility**  
   Fully functional across modern browsers with SockJS fallback support.  

7. **User-Friendly**  
   Easy-to-use chat interface with minimal configuration required.  

---

## ⚙️ Steps to Run the Application
1. Clone the repository:
    ```bash
    git clone https://github.com/your-repo/chat-application.git
    ```
2. Navigate to the project folder:
    ```bash
    cd chat-application
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```
5. Access the application in a browser at:
    ```bash
    http://localhost:8080/chat
    ```

---

## 📡 Endpoints

| **Endpoint**        | **Description**                     |
|----------------------|-------------------------------------|
| `/chat`             | WebSocket connection endpoint       |
| `/app/sendmessage`  | Sends messages to the server        |
| `/topic/message`    | Broadcasts messages to all clients  |

---

## 🛠️ Technologies Used
- Spring Boot for backend development  
- WebSocket and STOMP for real-time communication  
- SockJS for WebSocket fallback  
- Tailwind CSS for styling  
- MySQL for optional database integration  

---

## 💾 Database Integration
To store messages in the database, follow these steps:

1. Configure the database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/chatdb
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```
2. Create a repository interface:
    ```java
    public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {}
    ```
3. Save messages in the controller:
    ```java
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @MessageMapping("/sendmessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(ChatMessage message) {
        chatMessageRepository.save(message);
        return message;
    }
    ```

---

## 🚀 Testing the Application
- Run the application and open `http://localhost:8080/chat` in multiple browser tabs.  
- Enter a username and a message in one tab and send it.  
- Verify that the message appears in real-time in all tabs.  

---

© 2024 Real-Time Chat Application. Built with Spring Boot and Tailwind CSS.
