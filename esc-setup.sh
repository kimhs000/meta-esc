#!/bin/sh
 
LAYERS_DIR=./sources/base/conf/
LAYER_ESC_STRING="BBLAYERS += \"\${BSPDIR}/sources/meta-esc\""
 
if [ -w ${LAYERS_DIR}/bblayers.conf ]
then
    grep "${LAYER_ESC_STRING}" "${LAYERS_DIR}/bblayers.conf" > /dev/null
    TMPRETVAL=$(echo $?)
    TMPPRINT=""
 
    if [ ${TMPRETVAL} -eq 0 ]
    then
        TMPPRINT="already present"
    fi
 
    if [ ${TMPRETVAL} -eq 1 ]
    then
        echo "${LAYER_ESC_STRING}" >> ${LAYERS_DIR}/bblayers.conf
        TMPPRINT="added"
    fi
 
    echo "Layer meta-esc ${TMPPRINT}"
fi

