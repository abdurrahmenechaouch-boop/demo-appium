 demo-Appium Test Automation

Automatisation mobile Android avec Appium, Cucumber, JUnit et génération de rapports Allure.
Support pour tests locaux et sur le cloud via BrowserStack.

######################## Prérequis ################################################################################################

Java 17 ou supérieur

Maven 3.9+

Node.js (optionnel si Appium server local est utilisé)

Appium server (local ou BrowserStack)

Git

Allure CLI (optionnel pour générer et ouvrir les rapports depuis le terminal)

######################## Installation #############################################################################################

Cloner le dépôt :

git clone https://github.com/TON_USERNAME/demo-appium.git
cd demo-appium


Installer les dépendances Maven :

mvn clean install

######################## Exécution des tests ######################################################################################
💻 Tests locaux

Assure-toi que Appium server est lancé sur ton ordinateur (127.0.0.1:4723) :

export RUN_ON_BROWSERSTACK=false
mvn test

🌐 Tests sur BrowserStack

Définis tes identifiants BrowserStack et active l’exécution cloud :

export BROWSERSTACK_USERNAME=ton_username
export BROWSERSTACK_ACCESS_KEY=ton_access_key
export RUN_ON_BROWSERSTACK=true
mvn test


Le flag RUN_ON_BROWSERSTACK permet de basculer entre exécution locale et cloud.

######################## Configuration des variables d’environnement ##############################################################

RUN_ON_BROWSERSTACK=true;BROWSERSTACK_USERNAME=ton_username;BROWSERSTACK_ACCESS_KEY=ton_access_key


######################## Structure du projet ######################################################################################
demo-appium/
├─ src/
│  ├─ main/
│  │  └─ java/               # Code principal (drivers, utilitaires…)
│  └─ test/
│     ├─ java/               # Step definitions et Hooks
│     └─ resources/          # Fichiers .feature et autres ressources de test
│         └─ features/       # Scénarios Cucumber
├─ pom.xml                   # Projet Maven
├─ .gitignore
└─ README.md

######################## Allure Reports ###########################################################################################

Les screenshots sont capturés automatiquement en cas d’échec et intégrés dans le rapport Allure.

Compatible avec Scenario Outline, DataTables, Android 13 et UiAutomator2.

######################## Commandes utiles #########################################################################################
# Clean et build le projet
mvn clean install

# Exécuter les tests
mvn test

# Générer et ouvrir le rapport Allure automatiquement
allure generate target/allure-results -o target/allure-report --clean
allure open target/allure-report


💡 Astuce : tu peux ajouter la génération Allure après chaque test dans Maven avec le plugin Allure Maven ou créer un alias bash.

Badges & Status

✅ Tests passés localement et sur BrowserStack

📸 Screenshots sur échec automatiquement

🧪 Compatible avec plusieurs utilisateurs via Scenario Outline

👤 Auteur

Abdurrahmene Chaouch

[LinkedIn] (https://www.linkedin.com/public-profile/settings?trk=d_flagship3_profile_self_view_public_profile)