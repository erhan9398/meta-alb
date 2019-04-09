# Copyright (C) 2013 Freescale Semiconductor
# Released under the MIT license (see COPYING.MIT for the terms)
# Copyright 2017-2018 NXP

inherit module

DESCRIPTION = "GPU kernel module for s32v2xx"
SECTION = "libs"
LICENSE = "GPL-2.0"

PROVIDES = "kernel-module-galcore${KERNEL_MODULE_PACKAGE_SUFFIX}"
RPROVIDES_${PN} = "kernel-module-galcore${KERNEL_MODULE_PACKAGE_SUFFIX}"

SRC_URI = " git://source.codeaurora.org/external/autobsps32/galcore;branch=alb/master;protocol=https "
SRCREV = "7eed97bdbd065a8990c3d6b526e0d63d383d9871"

LIC_FILES_CHKSUM = "file://GPLv2;md5=fcb02dc552a041dee27e4b85c7396067"

PR = "r0"

# Backwards compatibility. Use older revisions for older kernel versions.
KERNEL_NAME = "${PREFERRED_PROVIDER_virtual/kernel}"
KERNEL_VER = '${@d.getVar("PREFERRED_VERSION_${KERNEL_NAME}",True)}'

# For older kernel versions, currently only 4.1 is supported
OLD_KERNEL_INCLUDE = "kernel-module-galcore-old-${KERNEL_VER}.inc"

include ${OLD_KERNEL_INCLUDE}

S = "${WORKDIR}/git"

# MACHINE_EXTRA_RRECOMMENDS += "kernel-module-galcore"

FILES_${PN} += "/lib/modules/${KERNEL_VERSION}/kernel/drivers/mxc/gpu-viv/galcore.ko"
FILES_${PN} += "/etc/modules-load.d/galcore.conf"

do_install_append(){
	echo "galcore" > ${S}/galcore.conf
	install -d ${D}/etc/modules-load.d/
	install -m 0644 ${S}/galcore.conf ${D}/etc/modules-load.d/

	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/mxc/gpu-viv
	install -m 0644 ${S}/build/sdk/drivers/galcore.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/mxc/gpu-viv/
}

COMPATIBLE_MACHINE = "(s32v234evb)|(s32v234pcie)|(s32v234bbmini)|(s32v234evb28899)|(s32v234sbc)"
