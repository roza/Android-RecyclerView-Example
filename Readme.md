# AndroidNotes

## But 

Une petite app de gestion de notes personnelles. Chaque note a un titre et un contenu textuel.

En mode écriture, on se contente d’afficher une zone de texte éditable et un bouton "Envoyer".
En mode consultation, l’app est décomposée en deux parties : 
- la liste des notes enregistrées (affichant uniquement leur titre)
- le détail d’une note (affichant titre et contenu de la note sélectionnée).


## Classe Note

La classe Note est destinée à représenter une note (titre + contenu, tous deux de type String). Elle doit comporter des méthodes publiques *getTitre()* et *getContenu()* permettant d’accéder à son contenu. 

## La classe ListeNotes 

permet de gérer une liste de notes. Cette
classe dispose des méthodes suivantes :
— *ajouteNote(String titre, String contenu)* créant une nouvelle note et l’ajoutant en fin de liste ;
— *get(int)* renvoyant une note à partir de sa position ;
— *deleteNote(int)* permettant d’effacer la note dont l’index est passé en paramètre ;
— *deleteNote(String)* permettant d’effacer la note dont le titre est passé en para- mètre, et retournant l’index de la position qu’occupait cette note ;
— size() retournant le nombre de notes stockées.

La liste est affichée via un RecyclerView

## Fragments

L’app comprend deux fragments : 
- celui affiché en haut s’occupe de l’affichage des notes
- celui du bas a pour fonction de gérer l’affichage complet d’une note selectionnée.


## Modification

La modification d’un élément d’une liste affichée via un RecyclerView se fait en deux temps :
- on procède d'abord à la modification proprement dite, ensuite, on notifie au *RecyclerView.Adapter*le changement via la méthode la plus appropriée.
La liste des méthodes permettant d’effectuer ces notifications est disponible là : https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html

## Observez bien

1. Dans NoteFragment, la  méthode *addNote* permettant d’ajouter une note à la liste et notifiant cet ajout à l’adapter.
2. La méthode *deleteNote* permettant de supprimer une note à la liste à partir de son titre (et notifiant aussi cette suppression à l’adapter).
3.Communication Activity/Fragment et affichage complet d’une note.
L’appui sur un élément de la liste déclenche l'affichage complet de la note à l’écran dans le fragment correspondant. Cela s’effectue grâce à la méthode *onListFragmentInteraction* définie dans l’interface *NotesFragment.OnListFragmentListener* que l’activité principale implémente.
4. Pour récupérer l’instance du *NoteDetailFragment* que l’activité principale a instancié à sa création, on peut utiliser le *FragmentManager* de l’activité (accessible via getSupportFragmentManager) et sa méthode *findFragmentById*.
5. La méthode *onListFragmentInteraction*  appelle la méthode *Update* du fragment récupéré dans la question précédente.
6. L’affichage des deux fragments se fait cote à cote (et non plus l’un en dessous de l’autre) lorsque l’appareil est tourné en mode paysage. (c’est possible en ne touchant qu’au répertoire res)