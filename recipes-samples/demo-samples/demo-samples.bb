# Copyright 2017 NXP
# To bitbake this recipe you should follow the steps from
# the readme file of the yocto layer.
#

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=d1fe458e57ae72e9abc9aff2684690d0"
SRC_URI = "git://source.codeaurora.org/external/autobsps32/alb-demos;branch=alb/master;protocol=https"

SRC_URI[md5sum] = "fb105258940e1a6730f8db534b2f9b37"

S = "${WORKDIR}/git"
<<<<<<< HEAD
SRCREV = "28323d167ac06318077a1c9532048a3c0bd57e33"
=======
SRCREV = "fddce98e559d44f136cbc716ddff69831243d29e"
>>>>>>> develop
SAMPLESDIR = "/opt/samples"
DESTDIR = "${D}${SAMPLESDIR}"

do_install() {
        install -d ${DESTDIR}
        oe_runmake install INSTALLDIR=${DESTDIR}
}

FILES_${PN} = "${SAMPLESDIR}"
FILES_${PN}-dbg += "${SAMPLESDIR}/.debug"

COMPATIBLE_MACHINE = "s32v234evb|s32v234pcie|s32v234tmdp|s32v234bbmini"
