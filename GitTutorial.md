# CS2413-Project_1
Uno card project using OOP. Each card has associated exercies and output most be formatted.

Collabs: 

This is primarily only for the code we will develope in lab.
As such, I have some rules to follow and will include instructions here.

RULES:
DO NOT DIRECTLY UPLOAD TO GITHUB! (Without asking first, this messes up git a lil bit)
When making a commit, Make your comment informational, include changes to files commited.


INSTRUCTIONS:

Setting Up:
1.	You'll need to create a username for git for when you commit things. Enter "git config --global user.name "Your name Here""
2.	Either download Notepad++ (recommended) or enter this into terminal "git config core.editor notepad"

Getting Started (1st time):
1.	Goto an empty folder (ie "Project Lab 1")
2.	Right click and select "Git bash Here"
3.	Enter "git clone https://github.com/Akhil-Kapadia/CS2413-Project_1" (Without "")
4.	This will create the current repo in a new folder inside your project lab folder. Go ahead and close git, and open the "CS2413-Project_1" folder. Right click and open git bash again.
5.	You are now in the shared repo. Edit files here using Vivado or whatever.

I Highly recommend that you learn how git works before following this tutorial. Pushing to github without knowing how branches, commits and what pull requests can mess up the flow of the team.
Please try and learn how to maintain your own branch instead of always pushing to the master branch.

BRANCHING
1.	A branch is basically a copy of the master tree where the central code is. Make a branch for when you're working on code individually. When you're ready we can merge your branch with the groups master branch.
When naming your branch follow the format of "firstName_issueBeingWorkedOn_versionNunmber" Ie "Akhil_cardNotFound_1"
Use Command		git branch Akhil_cardNotFound_1
2.	To go to a branch created (Either yours or a group members)
Use Command		git checkout Akhil_cardNotFound_1

MERGING YOUR BRANCH TO GROUP MASTER
After you've pushed to your branch and are ready to merge it with the master code, you'll need to create a pull request. Do this by going to the github website, clicking on your branch.
The rest is self explanatory, just go through submitting a pull request, and msg Jacob to have him confirm and merge the request.

SAVING YOUR CHANGES:
(Assuming git's already open in the repo) 
1.	You'll need to "commit" the changes. What this does is it record the changes you've made. ie old file - new file = changes. This doesn't upload anything though, it just tells git what changes need to be uploaded. 
MAKE SURE WHEN YOU COMMIT, COMMENT WHAT CHANGES YOU'VE MADE!
Enter: git commit -m "Changes made here" fileName.type
You can use "git status" to find out what files you've changed.
2.	To actually save you changes to github you'll need to "push" the commit you've made. Be prepared, you might need to login in to github.
Enter "git push"
3.	Done!

ADDING A FILE:
1.	TO add a file to the repo:
Enter "git add fileName.type"
Then commit and push following tut above.

FIND PAST VERSIONS:
Goto the github repo and click on commits.

Thats about it!
