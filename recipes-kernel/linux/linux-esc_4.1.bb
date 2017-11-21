# Copyright (C) 2015, 2017 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "FSL Community BSP i.MX Linux kernel with backported features and fixes"
DESCRIPTION = "Linux kernel based on NXP 4.1.15-1.2.0 GA release, used by FSL Community BSP in order to \
provide support for i.MX based platforms and include official Linux kernel stable updates, backported \
features and fixes coming from the vendors, kernel community or FSL Community itself."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

#include linux-fslc.inc

#PV .= "+git${SRCPV}"
PV .= ""

SRCBRANCH = "rocko"
LOCALVERSION = "-yocto"

SRCREV = "2135c1aebca1830adb4c57e39c46ad336e045f69"

SRC_URI = "git://github.com/kimhs000/esc-linux-4.1.git;branch=${SRCBRANCH} \
           file://defconfig"

COMPATIBLE_MACHINE = "(mx6|mx7|imx6q-esc)"
