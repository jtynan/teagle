'''
Created on 17.07.2011

@author: kca
'''

import logging
from ngniutils.logging import get_logger
from subprocess import check_output as _check_output, check_call as _check_call, CalledProcessError, STDOUT

def _pre_call(args):
	#needed for chroot safety
	import encodings.string_escape
	
	cmd = ' '.join(args)
	get_logger().debug("running %s" % (cmd, ))
	return cmd
	

def check_output(args, stderr = STDOUT):
	cmd = _pre_call(args)
	
	try:
		return _check_output(args, stderr = stderr)
	except CalledProcessError, e:
		get_logger().debug("Command %s returned exit code %s. This is the programs output:\n%s<<EOF>>" % (cmd, e.returncode, e.output))
		raise
	
def check_call(args, stdin=None, stdout=None, stderr=None, shell=False, cwd = None, env = None,  *popenargs, **popenkw):
	cmd = _pre_call(args)
	
	try:
		return _check_call(args, stdin = stdin, stdout = stdout, stderr = stderr, shell = shell, cwd = cwd, env = env, *popenargs, **popenkw)
	except CalledProcessError, e:
		get_logger().debug("Command %s returned exit code %s." % (cmd, e.returncode))
		raise
