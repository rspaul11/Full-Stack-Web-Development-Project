# Full-Stack Web Development Projects

A collection of full-stack web applications built with **Java backend** and modern frontend technologies.

## 📋 Projects

| # | Project | Description | Tech Stack |
|---|---------|-------------|------------|
| 1 | **Online Banking App** | Complete banking system with accounts, transactions, and security | Java, Spring Boot, Vue.js, MySQL |
| 2 | **PaulifyStay** | Property rental and accommodation booking platform | Java, Spring Security, JavaScript, PostgreSQL |
| 3 | **PaulWay** | Travel planning and interactive maps application | Java, Spring MVC, TypeScript, Map APIs |
| 4 | **Paulicious** | Food delivery and restaurant ordering system | Java, REST APIs, Vue.js, MongoDB |
| 5 | **Paulournal** | Personal journaling and note-taking application | Java, Spring Boot, JavaScript, MySQL |
| 6 | **Paulora** | Job portal with resume upload and employer matching | Java, Spring Security, CSS, PostgreSQL |

## 🛠️ Technology Breakdown

**Backend (57.2%):** Java, Spring Boot, Spring Security, REST APIs  
**Frontend:** CSS (18.4%), JavaScript (13.3%), TypeScript (4.1%), Vue (3.7%), HTML (3.2%)  
**Database:** MySQL, PostgreSQL, MongoDB  
**Tools:** Docker (0.1%), Maven, Git

## 🚀 Quick Setup

### Prerequisites
- Java JDK 11+
- Maven 3.6+
- Node.js 14+
- MySQL/PostgreSQL

### Installation
```bash
# Clone the repository
git clone https://github.com/rspaul11/Full-Stack-Web-Development-Project.git

# Choose a project
cd Full-Stack-Web-Development-Project/Online-Banking-App

# Backend setup
cd backend
mvn clean install
mvn spring-boot:run

# Frontend setup (in another terminal)
cd frontend
npm install
npm start
```

## 📁 Project Structure
Each project follows this pattern:
```
Project-Name/
├── backend/                    # Java Spring Boot Application
│   ├── src/main/java/         # Source code
│   ├── pom.xml               # Maven dependencies
│   └── application.properties # Database config
├── frontend/                  # Web interface
│   ├── src/                  # Vue/JavaScript files
│   └── package.json          # Node dependencies
└── README.md                 # Project-specific guide
```

## 🔧 Common Features
- User authentication & authorization
- RESTful API design
- Database integration
- Responsive web design
- Form validation
- Error handling
