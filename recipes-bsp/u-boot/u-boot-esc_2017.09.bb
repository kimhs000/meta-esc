# Copyright (C) 2012-2017 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)

require recipes-bsp/u-boot/u-boot.inc
inherit fsl-u-boot-localversion


DESCRIPTION = "U-Boot bootloader with support for ESC board"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

COMPATIBLE_MACHINE = "(mxs|mx5|mx6|mx7|vf|imx6q-esc)"

PROVIDES += "u-boot"

PV = "v2017.09+git${SRCPV}"

SRCBRANCH = "rocko"
SRC_URI = "git://github.com/kimhs000/esc-uboot-v2017.09.git;branch=${SRCBRANCH}"

#SRCREV is the commit number, must be always changed for a new version
SRCREV = "4b057319721d96085185ea6c6d55377ff11e0fd6"

S = "${WORKDIR}/git"

DEPENDS_append = " dtc-native"

# FIXME: Allow linking of 'tools' binaries with native libraries
#        used for generating the boot logo and other tools used
#        during the build process.
EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="${BUILD_LDFLAGS}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"


