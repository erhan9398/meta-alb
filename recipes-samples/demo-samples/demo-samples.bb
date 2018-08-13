# Copyright 2017 NXP

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.BSD;md5=d1fe458e57ae72e9abc9aff2684690d0"
SRC_URI = "git://source.codeaurora.org/external/autobsps32/alb-demos;branch=alb/master;protocol=https"

S = "${WORKDIR}/git"
SRCREV = "bf271b880f211977938a40884e209a6192c33765"
SAMPLESDIR = "/opt/samples"
DESTDIR = "${D}${SAMPLESDIR}"

do_install() {
        install -d ${DESTDIR}
        oe_runmake install INSTALLDIR=${DESTDIR}
}

FILES_${PN} = "${SAMPLESDIR}"
FILES_${PN}-dbg += "${SAMPLESDIR}/.debug"

COMPATIBLE_MACHINE = "s32v234evb|s32v234pcie|s32v234tmdp|s32v234bbmini|s32v234sbc"
