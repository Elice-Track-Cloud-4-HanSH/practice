# Command line instructions   
You can also upload existing files from your computer using the instructions below.


# Git global setup
```
git config --global user.name "[CLOUD4] 한상현"
git config --global user.email "gkstkdgus821@gmail.com"
```

# Create a new repository
```
git clone https://kdt-gitlab.elice.io/cloud_track/class_04/class_041/project/han-sanghyeon-practice.git
cd han-sanghyeon-practice
touch README.md
git add README.md
git commit -m "add README"
git push -u origin master
```

# Push an existing folder
```
cd existing_folder
git init
git remote add origin https://kdt-gitlab.elice.io/cloud_track/class_04/class_041/project/han-sanghyeon-practice.git
git add .
git commit -m "Initial commit"
git push -u origin master
```

# Push an existing Git repository
```
cd existing_repo
git remote rename origin old-origin
git remote add origin https://kdt-gitlab.elice.io/cloud_track/class_04/class_041/project/han-sanghyeon-practice.git
git push -u origin --all
git push -u origin --tags
```

## change datas