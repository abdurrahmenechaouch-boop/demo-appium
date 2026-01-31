1️⃣ Démarrer l’émulateur Android

👉 Vérifie d’abord qu’un device est lancé :

emulator -list-avds


Lance ton émulateur (exemple) :

emulator -avd Pixel_7_API_33


Ou via Android Studio → Device Manager → ▶️

Puis vérifie :

adb devices


Tu dois voir :

emulator-5554   device

2️⃣ Démarrer Appium Server (IMPORTANT)

Avec Appium 2.x, PAS de /wd/hub ❌

appium


Tu dois voir dans les logs :

Appium REST http interface listener started on http://127.0.0.1:4723
