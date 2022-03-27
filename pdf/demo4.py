try:
    file = open("../files/mots.txt", "r", encoding="utf-8");
except FileNotFoundError:
    print("Erreur: Fichier introuvable !");
    exit(0);

content = file.read();
file.close();

words = content.split();
results = [];

for mot in words:
    double = 0;
    i = 0;

    while i < len(mot)-1 and double < 4:
        if mot[i] == mot[i+1]:
            double += 1;
            i += 3;
        else:
            i += 1;

    if double == 4:
        results.append(mot);

for w in results:
    print(w);
