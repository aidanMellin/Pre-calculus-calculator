#!/bin/bash
chmod +x file
ls
cd eclipse-workspace/pcCalc/src

PS3='Please enter your choice: '
options=("Base" "unitCircle" "DemoShapes" "Quit")
select opt in "${options[@]}"
do
    case $opt in
        "Base")
            echo "you chose choice 1"
		open autoRun.command
            ;;
        "unitCircle")
            echo "you chose choice 2"
		open unitCircleRun.command
            ;;
        "DemoShapes")
            echo "you chose choice $REPLY which is $opt"
		open DemoShapesRun.command
            ;;
        "Quit")
            break
            ;;
        *) echo "invalid option $REPLY";;
    esac
done